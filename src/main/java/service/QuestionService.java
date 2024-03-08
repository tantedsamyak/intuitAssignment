package main.java.service;

import main.java.Repository.QuestionRepository;
import main.java.Repository.QuestionTagRepository;
import main.java.models.Question;
import main.java.models.QuestionRequest;
import main.java.models.Tag;

import java.util.List;

public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TagService tagService;

    private final QuestionTagRepository questionTagRepository;

    public QuestionService(QuestionRepository questionRepository, TagService tagService, QuestionTagRepository questionTagRepository) {
        this.questionRepository = questionRepository;
        this.tagService = tagService;
        this.questionTagRepository = questionTagRepository;
    }


    public List<Question> getTopQuestions() {
        return questionRepository.getTopQuestions();
    }

    public Question postQuestion(QuestionRequest questionRequest) {
        Question question = questionRequest.build();
        List<String> tagNames = questionRequest.getTagNames();

        question = questionRepository.saveQuestion(question);

        System.out.println("Question Saved in Repo..");

        List<Tag> tagList = tagService.getTagsByNames(tagNames);

        System.out.println("Tags created");

        for (Tag tag : tagList) {
            questionTagRepository.saveQuestionTag(question.getQuestionID(), tag.getTagID());
        }
        System.out.println("question and tags are saved");
        return question;
    }

    public Question getQuestionById(int questionId) {
        return questionRepository.getQuestionById(questionId);
    }

    public List<Question> searchQuestionsByText(String searchText) {
        return questionRepository.getQuestionByText(searchText);

    }

    public List<Question> getQuestionsByTag(String tagName) {
        return questionTagRepository.getQuestionsByTag(tagName);
    }
}