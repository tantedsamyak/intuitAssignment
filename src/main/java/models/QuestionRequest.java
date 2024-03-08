package main.java.models;

import java.util.List;

public class QuestionRequest {
    private int userID;
    private String title;
    private String body;
    private List<String> tagNames;

    public QuestionRequest(int userID, String title, String body, List<String> tagNames) {
        this.userID = userID;
        this.title = title;
        this.body = body;
        this.tagNames = tagNames;
    }


    public Question build() {
        Question question = new Question();
        question.setUserID(userID);
        question.setTitle(title);
        question.setBody(body);
        // Set tags
        return question;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionRequest)) return false;
        final QuestionRequest other = (QuestionRequest) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getUserID() != other.getUserID()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        final Object this$tagNames = this.getTagNames();
        final Object other$tagNames = other.getTagNames();
        if (this$tagNames == null ? other$tagNames != null : !this$tagNames.equals(other$tagNames)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getUserID();
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        final Object $tagNames = this.getTagNames();
        result = result * PRIME + ($tagNames == null ? 43 : $tagNames.hashCode());
        return result;
    }

    public String toString() {
        return "QuestionRequest(userID=" + this.getUserID() + ", title=" + this.getTitle() + ", body=" + this.getBody() + ", tagNames=" + this.getTagNames() + ")";
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

    public List<String> getTagNames() {
        return this.tagNames;
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

    public void setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
    }
}
