package tms.instaclone.entity;

import tms.instaclone.enums.PostType;

import java.util.List;

public class Story extends Post {
    public static final int STORY_LIFESPAN_HOURS = 24;

    public Story(User owner, PostType postType, List<String> videoOrImagePath) {
        super(owner, postType, videoOrImagePath);
    }
}