package main.java.Repository;

import main.java.models.Vote;
import main.java.models.VoteCandidate;
import main.java.models.VoteType;

import java.util.ArrayList;
import java.util.List;

public class VoteRepository {
    private final List<Vote> votes = new ArrayList<>();
    private int  voteCounter =0;

    public boolean hasUserVoted(int userID, int candidateId, VoteCandidate voteCandidate) {
        // Check if the user has already voted on the question or answer
        for (Vote vote : votes) {
            if (vote.getUserID() == userID &&
                    ((candidateId != 0 && vote.getCandidateId() == candidateId) &&
                            (voteCandidate != null && vote.getVoteCandidate() == voteCandidate))) {
                return true;
            }
        }
        return false;
    }

    public void saveVote(int userID, int candidateId, VoteCandidate voteCandidate, VoteType voteType) {
        Vote vote = new Vote(voteCounter++,userID,candidateId,voteCandidate,voteType);
        votes.add(vote);
    }

}