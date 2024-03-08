package main.java.models;

import java.time.LocalDateTime;
import java.util.List;

public class Question {
    private int questionID;
    private int userID;
    private String title;
    private String body;
    private LocalDateTime timestamp;
    private int upvotes = 0;
    private int downvotes = 0;
    private List<Tag> tags;

    public Question() {
    }


    public void updateVote(VoteType voteType) {
        if (voteType.equals(VoteType.UP_VOTE)) {
            upvotes++;
        } else {
            downvotes++;
        }
    }


    public String toString() {
        return "Question(questionID=" + this.getQuestionID() + ", userID=" + this.getUserID() + ", title=" + this.getTitle() + ", body=" + this.getBody() + ", timestamp=" + this.getTimestamp() + ", upvotes=" + this.getUpvotes() + ", downvotes=" + this.getDownvotes() + ", tags=" + this.getTags() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Question)) return false;
        final Question other = (Question) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getQuestionID() != other.getQuestionID()) return false;
        if (this.getUserID() != other.getUserID()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        if (this.getUpvotes() != other.getUpvotes()) return false;
        if (this.getDownvotes() != other.getDownvotes()) return false;
        final Object this$tags = this.getTags();
        final Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Question;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getQuestionID();
        result = result * PRIME + this.getUserID();
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        result = result * PRIME + this.getUpvotes();
        result = result * PRIME + this.getDownvotes();
        final Object $tags = this.getTags();
        result = result * PRIME + ($tags == null ? 43 : $tags.hashCode());
        return result;
    }

    public int getQuestionID() {
        return this.questionID;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getTitle() {
        return this.title;
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

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    // Constructor, getters, and setters
}
