package tms.instaclone.entity;

public abstract class Entity {
    private long id;

    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                "{";
    }
}
