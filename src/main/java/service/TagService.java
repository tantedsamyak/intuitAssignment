package main.java.service;

import lombok.AllArgsConstructor;
import main.java.Repository.TagRepository;
import main.java.models.Tag;

import java.util.List;


public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTagsByNames(List<String> tagNames) {
        return tagRepository.getTagsByNames(tagNames);
    }
}