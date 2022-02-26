package tms.instaclone.entity;

import java.util.List;
import java.util.Objects;

public abstract class Post extends Entity {
    private User owner;
    private List<String> videoOrImagePath;
    private List<User> userWhoHasMadeLike;

    public Post(User owner, List<String> videoOrImagePath) {
        this.owner = owner;
        this.videoOrImagePath = videoOrImagePath;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return owner.equals(post.owner) && videoOrImagePath.equals(post.videoOrImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, videoOrImagePath);
    }

    @Override
    public String toString() {
        return "Post{" +
                "owner=" + owner +
                ", videoOrImagePath=" + videoOrImagePath +
                ", userWhoHasMadeLike=" + userWhoHasMadeLike +
                '{';
    }
}
