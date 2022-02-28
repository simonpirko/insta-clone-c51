package tms.instaclone.entity;

import tms.instaclone.enums.PostType;

import java.util.List;
import java.util.Objects;

public abstract class Post extends Entity {
    private User owner;
    private PostType postType;
    private List<String> videoOrImagePath;
    private List<User> userWhoHasMadeLike;

    public Post(User owner, PostType postType, List<String> videoOrImagePath) {
        this.owner = owner;
        this.postType = postType;
        this.videoOrImagePath = videoOrImagePath;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
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
        return owner.equals(post.owner) && postType == post.postType && videoOrImagePath.equals(post.videoOrImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, postType, videoOrImagePath);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Post{" +
                "owner=" + owner +
                ", postType=" + postType +
                ", videoOrImagePath=" + videoOrImagePath +
                ", userWhoHasMadeLike=" + userWhoHasMadeLike +
                '}' + '}';
    }
}
