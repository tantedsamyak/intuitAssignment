package main.java.Repository;

import main.java.models.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagRepository {
    private final Map<Integer, Tag> tags = new HashMap<>();
    private int tagIdCounter = 1;

    public List<Tag> getTagsByNames(List<String> tagList) {
        // Implement logic to retrieve tags by names
        List<Tag> resultTags = new ArrayList<>();
        for (String tagI : tagList) {
            Tag tag = findTagByName(tagI);
            if (tag == null) {
                tag = new Tag();
                tag.setTagID(tagIdCounter++);
                tag.setTagName(tagI);
                tags.put(tag.getTagID(), tag);
            }
            resultTags.add(tag);
        }
        return resultTags;
    }

    public Tag findTagByName(String tagName) {
        for (Tag tag : tags.values()) {
            if (tag.getTagName().equals(tagName)) {
                return tag;
            }
        }
        return null;
    }

    public Tag getTagByID(int tagID) {
        if(tags.containsKey(tagID)){
            return   tags.get(tagID);
        }
        return null;
    }
}