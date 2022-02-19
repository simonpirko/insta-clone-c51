package tms.instaclone.entity;

import java.util.List;

public class UserPost<T,P> extends Entity{
    private String userName;
    private String name;
    private List<T> contentAddresses;
    private String location;
    private int likeCount;

    public UserPost() {
    }

    public UserPost(String userName, String name, List<T> contentAddresses, String location, int likeCount, List<P> comments) {
        this.userName = userName;
        this.name = name;
        this.contentAddresses = contentAddresses;
        this.location = location;
        this.likeCount = likeCount;
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
}
