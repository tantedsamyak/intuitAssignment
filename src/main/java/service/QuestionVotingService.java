package main.java.service;

import main.java.Repository.VoteRepository;
import main.java.models.Question;
import main.java.models.User;
import main.java.models.VoteCandidate;
import main.java.models.VoteType;

public class QuestionVotingService implements VotingService {
    private final VoteRepository voteRepository;
    private final UserService userService;
    private final QuestionService questionService;

    public QuestionVotingService(VoteRepository voteRepository, UserService userService, QuestionService questionService) {
        this.voteRepository = voteRepository;
        this.userService = userService;
        this.questionService = questionService;
    }


    @Override
    public void vote(int userID, int questionId, VoteCandidate voteCandidate, VoteType voteType) {
        if (!voteRepository.hasUserVoted(userID, questionId, voteCandidate)) {
            // Update user reputation based on the voteType
            User user = userService.getUser(userID);
            int reputationChange = voteType.equals(VoteType.UP_VOTE) ? 1 : -1;
            user.setReputation(user.getReputation() + reputationChange);

            Question question = questionService.getQuestionById(questionId);
            question.updateVote(voteType);

            voteRepository.saveVote(userID, questionId, voteCandidate, voteType);
        }
    }
}