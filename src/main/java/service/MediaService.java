package main.java.service;

import main.java.models.Media;
import main.java.models.MediaStrategy;

import java.util.List;

public class MediaService {
    private final MediaStrategy mediaStrategy;

    public MediaService(MediaStrategy mediaStrategy) {
        this.mediaStrategy = mediaStrategy;
    }

    public List<Media> processMedia(List<String> mediaData) {
        return mediaStrategy.processMedia(mediaData);
    }
}
