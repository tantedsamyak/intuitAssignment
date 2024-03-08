package main.java.models;

public class Tag {
    private int tagID;
    private String tagName;

    public Tag() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Tag)) return false;
        final Tag other = (Tag) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getTagID() != other.getTagID()) return false;
        final Object this$tagName = this.getTagName();
        final Object other$tagName = other.getTagName();
        if (this$tagName == null ? other$tagName != null : !this$tagName.equals(other$tagName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Tag;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getTagID();
        final Object $tagName = this.getTagName();
        result = result * PRIME + ($tagName == null ? 43 : $tagName.hashCode());
        return result;
    }

    public String toString() {
        return "Tag(tagID=" + this.getTagID() + ", tagName=" + this.getTagName() + ")";
    }

    public int getTagID() {
        return this.tagID;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    // Constructor, getters, and setters
}