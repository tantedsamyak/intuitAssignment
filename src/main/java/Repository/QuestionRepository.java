package main.java.Repository;


import main.java.models.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionRepository {
    private final Map<Integer, Question> questions = new HashMap<>();
    private int questionIdCounter = 1;

    public Question saveQuestion(Question question) {
        int questionId = questionIdCounter++;
        question.setQuestionID(questionId);
        questions.put(questionId, question);
        return question;
    }

    public List<Question> getTopQuestions() {
        return new ArrayList<>(questions.values());
    }


    public Question getQuestionById(Integer questionId) {
        return questions.get(questionId);
    }

    public List<Question> getQuestionByText(String searchText) {
        return questions.values().stream().filter(question -> question.getTitle().equals(searchText)).collect(Collectors.toList());
    }
}