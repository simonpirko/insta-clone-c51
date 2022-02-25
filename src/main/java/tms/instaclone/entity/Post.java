package tms.instaclone.entity;

import java.util.List;

public class Post extends Entity {
    private User owner;
    private String title;
    private List<String> videoOrImagePath;
    private List<User> userWhoHasMadeLike;

    public Post() {
    }

    public Post(User owner, String title, List<String> videoOrImagePath, List<User> userWhoHasMadeLike) {
        this.owner = owner;
        this.title = title;
        this.videoOrImagePath = videoOrImagePath;
        this.userWhoHasMadeLike = userWhoHasMadeLike;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getVideoOrImagePath() {
        return videoOrImagePath;
    }

    public void setVideoOrImagePath(List<String> videoOrImagePath) {
        this.videoOrImagePath = videoOrImagePath;
    }

    public List<User> getUserWhoHasMadeLike() {
        return userWhoHasMadeLike;
    }

    public void setUserWhoHasMadeLike(List<User> userWhoHasMadeLike) {
        this.userWhoHasMadeLike = userWhoHasMadeLike;
    }
}