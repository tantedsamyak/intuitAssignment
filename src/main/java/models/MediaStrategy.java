package main.java.models;

import java.util.List;

public interface MediaStrategy {
    List<Media> processMedia(List<String> mediaData);
}
