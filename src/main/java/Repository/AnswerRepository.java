package main.java.Repository;


import main.java.models.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerRepository {
    private final Map<Integer, Answer> answers = new HashMap<>();
    private int answerIdCounter = 1;

    public Answer saveAnswer(Answer answer) {
        int answerId = answerIdCounter++;
        answer.setAnswerID(answerId);
        answers.put(answerId, answer);
        return answer;
    }

    public List<Answer> getAnswersByQuestion(int questionID) {
        List<Answer> result = new ArrayList<>();
        for (Answer answer : answers.values()) {
            if (answer.getQuestionID() == questionID) {
                result.add(answer);
            }
        }
        return result;
    }

    public List<Answer> getAnswersByAnswer(int answerID) {
        return answers.values().stream().filter(answer -> (answer.getParentAnswerID())==answerID ).collect(Collectors.toList());
    }

    public Answer getAnswerById(int answerId) {
        return answers.get(answerId);
    }
}