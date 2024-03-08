package main.java.models;

public class QuestionTag {

    int questionTagId;

    int questionId;

    int tagID;

    public QuestionTag() {
    }


    public int getQuestionTagId() {
        return this.questionTagId;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public int getTagID() {
        return this.tagID;
    }

    public void setQuestionTagId(int questionTagId) {
        this.questionTagId = questionTagId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionTag)) return false;
        final QuestionTag other = (QuestionTag) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getQuestionTagId() != other.getQuestionTagId()) return false;
        if (this.getQuestionId() != other.getQuestionId()) return false;
        if (this.getTagID() != other.getTagID()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionTag;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getQuestionTagId();
        result = result * PRIME + this.getQuestionId();
        result = result * PRIME + this.getTagID();
        return result;
    }

    public String toString() {
        return "QuestionTag(questionTagId=" + this.getQuestionTagId() + ", questionId=" + this.getQuestionId() + ", tagID=" + this.getTagID() + ")";
    }
}
