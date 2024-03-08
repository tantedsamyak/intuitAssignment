package main.java.service;

import main.java.Repository.AnswerRepository;
import main.java.models.Answer;
import main.java.models.Media;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class AnswerService {

    private final AnswerRepository answerRepository;
    private final MediaService mediaService;

    public AnswerService(AnswerRepository answerRepository, MediaService mediaService) {
        this.answerRepository = answerRepository;
        this.mediaService = mediaService;
    }

    public Answer postAnswer(int userID, int questionID, String body, List<String> mediaData) {
        List<Media> media = mediaService.processMedia(mediaData);
        Answer answer = new Answer();
        answer.setUserID(userID);
        answer.setQuestionID(questionID);
        answer.setBody(body);
        answer.setMedia(media);
        return answerRepository.saveAnswer(answer);
    }

    public Answer postAnswerToAnswer(int userID, int parentAnswerID, String body, List<String> mediaData) {
        List<Media> media = mediaService.processMedia(mediaData);
        Answer answer = new Answer();
        answer.setUserID(userID);
        answer.setParentAnswerID(parentAnswerID);
        answer.setBody(body);
        answer.setMedia(media);
        return answerRepository.saveAnswer(answer);
    }

    public List<Answer> getAnswersByQuestion(int questionID) {
        return answerRepository.getAnswersByQuestion(questionID);
    }

    public List<Answer> getAnswersByAnswer(int answerID) {
        return answerRepository.getAnswersByAnswer(answerID);
    }

    public List<Answer> getAllAnswers(int questionID) {
        List<Answer> answers = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Answer> mainAnswer = answerRepository.getAnswersByQuestion(questionID);
        queue.addAll(mainAnswer.stream().map(answer -> answer.getAnswerID()).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            int answerId = queue.poll();
            answers.add(getAnswerById(answerId));
            List<Answer> answerList = getAnswersByAnswer(answerId);
            queue.addAll(answerList.stream().map(answer -> answer.getAnswerID()).collect(Collectors.toList()));
        }
        return answers;
    }

    public Answer getAnswerById(int answerId) {
        return answerRepository.getAnswerById(answerId);
    }
}