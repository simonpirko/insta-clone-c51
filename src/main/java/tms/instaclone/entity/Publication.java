package tms.instaclone.entity;

import tms.instaclone.enums.PostType;

import java.util.List;
import java.util.Objects;

public class Publication extends Post {
    private String caption;

    public Publication(User owner, PostType postType, List<String> videoOrImagePath, List<User> userWhoHasMadeLike) {
        super(owner, postType, videoOrImagePath, userWhoHasMadeLike);
    }

    public Publication(User owner, PostType postType, List<String> videoOrImagePath, List<User> userWhoHasMadeLike,
                       String caption) {
        super(owner, postType, videoOrImagePath, userWhoHasMadeLike);
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Publication that = (Publication) o;
        return Objects.equals(caption, that.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caption);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Publication{" +
                "caption='" + caption + '\'' +
                '}' + '}';
    }
}
