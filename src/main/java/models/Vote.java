package main.java.models;

public class Vote {
    private int voteID;
    private int userID;
    private int candidateId;
    private VoteCandidate voteCandidate;
    private VoteType voteType;

    public Vote(int voteID, int userID, int candidateId, VoteCandidate voteCandidate, VoteType voteType) {
        this.voteID = voteID;
        this.userID = userID;
        this.voteCandidate = voteCandidate;
        this.candidateId = candidateId;
        this.voteType = voteType;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Vote)) return false;
        final Vote other = (Vote) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getVoteID() != other.getVoteID()) return false;
        if (this.getUserID() != other.getUserID()) return false;
        if (this.getCandidateId() != other.getCandidateId()) return false;
        final Object this$voteCandidate = this.getVoteCandidate();
        final Object other$voteCandidate = other.getVoteCandidate();
        if (this$voteCandidate == null ? other$voteCandidate != null : !this$voteCandidate.equals(other$voteCandidate))
            return false;
        final Object this$voteType = this.getVoteType();
        final Object other$voteType = other.getVoteType();
        if (this$voteType == null ? other$voteType != null : !this$voteType.equals(other$voteType)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Vote;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getVoteID();
        result = result * PRIME + this.getUserID();
        result = result * PRIME + this.getCandidateId();
        final Object $voteCandidate = this.getVoteCandidate();
        result = result * PRIME + ($voteCandidate == null ? 43 : $voteCandidate.hashCode());
        final Object $voteType = this.getVoteType();
        result = result * PRIME + ($voteType == null ? 43 : $voteType.hashCode());
        return result;
    }

    public String toString() {
        return "Vote(voteID=" + this.getVoteID() + ", userID=" + this.getUserID() + ", candidateId=" + this.getCandidateId() + ", voteCandidate=" + this.getVoteCandidate() + ", voteType=" + this.getVoteType() + ")";
    }

    public int getVoteID() {
        return this.voteID;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getCandidateId() {
        return this.candidateId;
    }

    public VoteCandidate getVoteCandidate() {
        return this.voteCandidate;
    }

    public VoteType getVoteType() {
        return this.voteType;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public void setVoteCandidate(VoteCandidate voteCandidate) {
        this.voteCandidate = voteCandidate;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }


    // Constructor, getters, and setters
}