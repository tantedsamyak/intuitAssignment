package main.java.models;

import java.time.LocalDateTime;
import java.util.List;

public class Answer {
    private int answerID;
    private int questionID;
    private int userID;
    public int parentAnswerID;
    private String body;
    private LocalDateTime timestamp;
    private int upvotes;
    private int downvotes;
    private List<Media> media;

    public Answer() {
    }

    public void updateVote(VoteType voteType) {
        if (voteType.equals(VoteType.UP_VOTE)) {
            upvotes++;
        } else {
            downvotes++;
        }
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Answer)) return false;
        final Answer other = (Answer) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getAnswerID() != other.getAnswerID()) return false;
        if (this.getQuestionID() != other.getQuestionID()) return false;
        if (this.getUserID() != other.getUserID()) return false;
        if (this.getParentAnswerID() != other.getParentAnswerID()) return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        if (this.getUpvotes() != other.getUpvotes()) return false;
        if (this.getDownvotes() != other.getDownvotes()) return false;
        final Object this$media = this.getMedia();
        final Object other$media = other.getMedia();
        if (this$media == null ? other$media != null : !this$media.equals(other$media)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Answer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getAnswerID();
        result = result * PRIME + this.getQuestionID();
        result = result * PRIME + this.getUserID();
        result = result * PRIME + this.getParentAnswerID();
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        result = result * PRIME + this.getUpvotes();
        result = result * PRIME + this.getDownvotes();
        final Object $media = this.getMedia();
        result = result * PRIME + ($media == null ? 43 : $media.hashCode());
        return result;
    }

    public String toString() {
        return "Answer(answerID=" + this.getAnswerID() + ", questionID=" + this.getQuestionID() + ", userID=" + this.getUserID() + ", parentAnswerID=" + this.getParentAnswerID() + ", body=" + this.getBody() + ", timestamp=" + this.getTimestamp() + ", upvotes=" + this.getUpvotes() + ", downvotes=" + this.getDownvotes() + ", media=" + this.getMedia() + ")";
    }

    public int getAnswerID() {
        return this.answerID;
    }

    public int getQuestionID() {
        return this.questionID;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getParentAnswerID() {
        return this.parentAnswerID;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public int getUpvotes() {
        return this.upvotes;
    }

    public int getDownvotes() {
        return this.downvotes;
    }

    public List<Media> getMedia() {
        return this.media;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setParentAnswerID(int parentAnswerID) {
        this.parentAnswerID = parentAnswerID;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }


    // Constructor, getters, and setters
}