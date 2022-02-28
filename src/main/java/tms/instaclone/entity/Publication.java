package tms.instaclone.entity;

import java.util.List;
import java.util.Objects;

public class Publication extends Post {
    private String title;

    public Publication(User owner, List<String> videoOrImagePath, String title) {
        super(owner, videoOrImagePath);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Publication that = (Publication) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Publication{" +
                "title='" + title + '\'' +
                '}' + '}';
    }
}
