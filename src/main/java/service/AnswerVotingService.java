package main.java.service;

import main.java.Repository.VoteRepository;
import main.java.models.Answer;
import main.java.models.User;
import main.java.models.VoteCandidate;
import main.java.models.VoteType;

public class AnswerVotingService implements VotingService {

    private final VoteRepository voteRepository;
    private final UserService userService;

    private final AnswerService answerService;

    public AnswerVotingService(VoteRepository voteRepository, UserService userService, AnswerService answerService) {
        this.voteRepository = voteRepository;
        this.userService = userService;
        this.answerService = answerService;
    }


    @Override
    public void vote(int userID, int answerId, VoteCandidate voteCandidate, VoteType voteType) {
        if (!voteRepository.hasUserVoted(userID, answerId, voteCandidate)) {
            // Update user reputation based on the voteType
            User user = userService.getUser(userID);
            int reputationChange = voteType.equals(VoteType.UP_VOTE) ? 1 : -1;
            user.setReputation(user.getReputation() + reputationChange);

            Answer answer = answerService.getAnswerById(answerId);
            answer.updateVote(voteType);

            voteRepository.saveVote(userID, answerId, voteCandidate, voteType);
        }
    }
}
