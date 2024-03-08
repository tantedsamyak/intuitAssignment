package main.java.models;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoMediaStrategy implements  MediaStrategy{
    @Override
    public List<Media> processMedia(List<String> mediaData) {
        return mediaData.stream()
                .map(photoUrl -> {
                    Media media = new Media();
                    media.setMediaType("photo");
                    media.setMediaURL(photoUrl);
                    return media;
                }).collect(Collectors.toList());
    }
}
