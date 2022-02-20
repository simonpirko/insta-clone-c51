package tms.instaclone.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class UserPost<T, P, E> extends Entity {
    private String userName;
    private String name;
    private List<T> contentAddresses;
    private String location;
    private int likeCount;
    private boolean like;
    private List<P> comments;
    private List<E> userWhoMakeLike;
    private Timestamp creationDate;
    private Timestamp updateDate;

    public UserPost() {
    }

    public UserPost(String userName, String name, List<T> contentAddresses, String location, int likeCount, boolean like, List<P> comments, List<E> userWhoMakeLike, Timestamp creationDate, Timestamp updateDate) {
        this.userName = userName;
        this.name = name;
        this.contentAddresses = contentAddresses;
        this.location = location;
        this.likeCount = likeCount;
        this.like = like;
        this.comments = comments;
        this.userWhoMakeLike = userWhoMakeLike;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getContentAddresses() {
        return contentAddresses;
    }

    public void setContentAddresses(List<T> contentAddresses) {
        this.contentAddresses = contentAddresses;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<P> getComments() {
        return comments;
    }

    public void setComments(List<P> comments) {
        this.comments = comments;
    }

    public List<E> getUserWhoMakeLike() {
        return userWhoMakeLike;
    }

    public void setUserWhoMakeLike(List<E> userWhoMakeLike) {
        this.userWhoMakeLike = userWhoMakeLike;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = Timestamp.valueOf(LocalDateTime.now());
    }
}
