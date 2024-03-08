package main.java.Repository;

import main.java.models.Question;
import main.java.models.QuestionTag;
import main.java.models.Tag;

import java.util.ArrayList;
import java.util.List;

public class QuestionTagRepository {
    private final TagRepository tagRepository;
    private final QuestionRepository questionRepository;

    // Assuming question_tags is an associative table with fields question_id and tag_id
    private final List<QuestionTag> questionTags = new ArrayList<>();
    private int questionTagIdCounter = 1;

    public QuestionTagRepository(TagRepository tagRepository, QuestionRepository questionRepository) {
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
    }

    public void saveQuestionTag(int questionID, int tagID) {
        QuestionTag questionTag = new QuestionTag();
        questionTag.setQuestionTagId(questionTagIdCounter++);
        questionTag.setQuestionId(questionID);
        questionTag.setTagID(tagID);
        questionTags.add(questionTag);
    }

    public List<Tag> getTagsByQuestion(int questionID) {
        List<Tag> resultTags = new ArrayList<>();
        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getQuestionId() == questionID) {
                int tagID = questionTag.getTagID();
                Tag tag = getTagByID(tagID);
                if (tag != null) {
                    resultTags.add(tag);
                }
            }
        }
        return resultTags;
    }

    public List<Question> getQuestionsByTag(String tagName) {
        Tag tag = tagRepository.findTagByName(tagName);
        // In-memory example: Return all tags associated with the given question
        List<Question> resultQuestion = new ArrayList<>();
        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getTagID() == tag.getTagID()) {
                int questionId = questionTag.getQuestionId();
                Question question = questionRepository.getQuestionById(questionId);
                if (question != null) {
                    resultQuestion.add(question);
                }
            }
        }
        return resultQuestion;
    }

    private Tag getTagByID(int tagID) {
       return tagRepository.getTagByID(tagID);
    }


}