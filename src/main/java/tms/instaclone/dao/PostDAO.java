package tms.instaclone.dao;

import tms.instaclone.entity.Post;
import tms.instaclone.entity.User;

import java.util.List;
import java.util.Optional;

public interface PostDAO extends DataAccessObject<Post> {

    List<Post> getListPostByUsername(User user);

    Optional<Post> getPostById(long id);
}