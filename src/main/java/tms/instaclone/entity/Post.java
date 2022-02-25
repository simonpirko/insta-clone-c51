package tms.instaclone.entity;

public abstract class Post extends Entity {
    private User owner;

    public Post() {
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
