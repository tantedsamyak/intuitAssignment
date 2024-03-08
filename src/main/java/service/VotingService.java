package main.java.service;

import main.java.models.VoteCandidate;
import main.java.models.VoteType;

public interface VotingService {
     void vote(int userID, int candidateId, VoteCandidate voteCandidate,VoteType voteType);
}
