package main.java.models;

public class Media {
    private int mediaID;
    private int answerID;
    private String mediaType;
    private String mediaURL;

    public Media() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Media)) return false;
        final Media other = (Media) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getMediaID() != other.getMediaID()) return false;
        if (this.getAnswerID() != other.getAnswerID()) return false;
        final Object this$mediaType = this.getMediaType();
        final Object other$mediaType = other.getMediaType();
        if (this$mediaType == null ? other$mediaType != null : !this$mediaType.equals(other$mediaType)) return false;
        final Object this$mediaURL = this.getMediaURL();
        final Object other$mediaURL = other.getMediaURL();
        if (this$mediaURL == null ? other$mediaURL != null : !this$mediaURL.equals(other$mediaURL)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Media;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getMediaID();
        result = result * PRIME + this.getAnswerID();
        final Object $mediaType = this.getMediaType();
        result = result * PRIME + ($mediaType == null ? 43 : $mediaType.hashCode());
        final Object $mediaURL = this.getMediaURL();
        result = result * PRIME + ($mediaURL == null ? 43 : $mediaURL.hashCode());
        return result;
    }

    public String toString() {
        return "Media(mediaID=" + this.getMediaID() + ", answerID=" + this.getAnswerID() + ", mediaType=" + this.getMediaType() + ", mediaURL=" + this.getMediaURL() + ")";
    }

    public int getMediaID() {
        return this.mediaID;
    }

    public int getAnswerID() {
        return this.answerID;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getMediaURL() {
        return this.mediaURL;
    }

    public void setMediaID(int mediaID) {
        this.mediaID = mediaID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    // Constructor, getters, and setters
}