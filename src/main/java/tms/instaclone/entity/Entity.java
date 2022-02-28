package tms.instaclone.entity;

import java.time.LocalDateTime;

public abstract class Entity {
    private long id;
    private LocalDateTime creationDateTime = LocalDateTime.now();
    private LocalDateTime updateDateTime = LocalDateTime.now();

    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", updateDateTime=" + updateDateTime +
                '{';
    }
}
