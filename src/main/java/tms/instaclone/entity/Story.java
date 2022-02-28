package tms.instaclone.entity;

import java.util.List;

public class Story extends Post {
    public static final int STORY_LIFESPAN_HOURS = 24;

    public Story(User owner, List<String> videoOrImagePath) {
        super(owner, videoOrImagePath);
    }
}