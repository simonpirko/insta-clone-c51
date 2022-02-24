package tms.instaclone.entity;

import java.util.List;

public class Post<T, P> extends Entity {
    private String userName;
    private String title;
    private List<T> VideoOrImagePath;
    private List<P> userWhoHasMadeLike;

    public Post() {
    }

    public Post(String userName, String title, List<T> videoOrImagePath, List<P> userWhoHasMadeLike) {
        this.userName = userName;
        this.title = title;
        VideoOrImagePath = videoOrImagePath;
        this.userWhoHasMadeLike = userWhoHasMadeLike;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<T> getVideoOrImagePath() {
        return VideoOrImagePath;
    }

    public void setVideoOrImagePath(List<T> videoOrImagePath) {
        VideoOrImagePath = videoOrImagePath;
    }

    public List<P> getUserWhoHasMadeLike() {
        return userWhoHasMadeLike;
    }

    public void setUserWhoHasMadeLike(List<P> userWhoHasMadeLike) {
        this.userWhoHasMadeLike = userWhoHasMadeLike;
    }
}