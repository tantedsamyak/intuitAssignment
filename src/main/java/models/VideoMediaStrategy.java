package main.java.models;

import java.util.List;
import java.util.stream.Collectors;

public class VideoMediaStrategy implements MediaStrategy{
    @Override
    public List<Media> processMedia(List<String> mediaData) {
        return mediaData.stream()
                .map(videoUrl -> {
                    Media media = new Media();
                    media.setMediaType("video");
                    media.setMediaURL(videoUrl);
                    return media;
                })
                .collect(Collectors.toList());
    }
}
