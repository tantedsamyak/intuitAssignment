import main.java.Repository.AnswerRepository;
import main.java.Repository.QuestionRepository;
import main.java.Repository.QuestionTagRepository;
import main.java.Repository.TagRepository;
import main.java.Repository.UserDAO;
import main.java.Repository.VoteRepository;
import main.java.Utils.Utils;
import main.java.models.Answer;
import main.java.models.Media;
import main.java.models.MediaStrategy;
import main.java.models.PhotoMediaStrategy;
import main.java.models.Question;
import main.java.models.QuestionRequest;
import main.java.models.User;
import main.java.models.VoteCandidate;
import main.java.models.VoteType;
import main.java.service.AnswerService;
import main.java.service.AnswerVotingService;
import main.java.service.MediaService;
import main.java.service.QuestionService;
import main.java.service.QuestionVotingService;
import main.java.service.TagService;
import main.java.service.UserService;
import main.java.service.VotingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        // Add USer
        User newUser = userService.createUser("Sam","Sam@xyz.com","pass");


        QuestionRepository questionRepository = new QuestionRepository();

        TagRepository tagRepository = new TagRepository();
        TagService tagService = new TagService(tagRepository);

        QuestionTagRepository questionTagRepository = new QuestionTagRepository(tagRepository, questionRepository);
        QuestionService questionService = new QuestionService(questionRepository, tagService, questionTagRepository);

        int userId = newUser.getUserID();
        String title = "Question_title";
        String body = "Question_body";
        List<String> tagNames = new ArrayList<>();
        tagNames.add("tag1");
        tagNames.add("tag2");

        // input Question
        QuestionRequest questionRequest = new QuestionRequest(userId, title, body, tagNames);
        System.out.println("QuestionRequest : " + questionRequest);

        Question question = questionService.postQuestion(questionRequest);
        System.out.println("Question : " + question.toString());

        // Answer to Question
        AnswerRepository answerRepository = new AnswerRepository();

        MediaStrategy mediaStrategy = new PhotoMediaStrategy();
        MediaService mediaService = new MediaService(mediaStrategy);

        AnswerService answerService = new AnswerService(answerRepository, mediaService);

        List<String> mediaData = new ArrayList<>();
        mediaData.add("base64_encoded");
        Answer answerFirst = answerService.postAnswer(userId, question.getQuestionID(),"answerBody", mediaData);

        List<Answer> answers = answerService.getAnswersByQuestion(question.getQuestionID());
        System.out.println("Answer for Question :" +  answers.toString());

        // Answer to Answer
        Answer childANswer = answerService.postAnswerToAnswer(userId, answerFirst.getAnswerID(),"answerChildBody", mediaData);

        List<Answer> answers2 = answerService.getAnswersByAnswer(answerFirst.getAnswerID());

        System.out.println("Answer for last Answer :" +  answers2.toString());

        // AllAnswers
        List<Answer> answers3 = answerService.getAllAnswers(question.getQuestionID());

        System.out.println("All Answer :" +  answers3.toString());

        // Voting
        VoteRepository voteRepository = new VoteRepository();
        VotingService questionVotingService = new QuestionVotingService(voteRepository,userService, questionService);
        questionVotingService.vote(userId, question.getQuestionID(), VoteCandidate.QUESTION, VoteType.UP_VOTE);

        System.out.println("Question : " + question.toString());

        VotingService answerVotingService = new AnswerVotingService(voteRepository,userService, answerService);
        answerVotingService.vote(userId, answerFirst.getAnswerID(), VoteCandidate.ANSWER, VoteType.DOWN_VOTE);

        System.out.println("AnswerFirst : " + answerFirst.toString());

        answerVotingService.vote(userId, childANswer.getAnswerID(), VoteCandidate.ANSWER, VoteType.DOWN_VOTE);

        System.out.println("Answer : " + childANswer.toString());

        // Search Question by text

        List<Question> questionListByText = questionService.searchQuestionsByText("Question_title");

        System.out.println("QuestionSearch By Text: " + questionListByText);


        // search question by tag

        List<Question> questionListByTag = questionService.getQuestionsByTag("tag1");
        System.out.println("QuestionSearch By Tag: " + questionListByTag);

        System.out.println("UserReputation : " + userService.getUser(userId));


    }
}