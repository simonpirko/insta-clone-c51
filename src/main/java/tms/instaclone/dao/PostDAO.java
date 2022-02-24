package tms.instaclone.dao;

import tms.instaclone.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDAO extends DataAccessObject<Post> {

    List<Post> getListPostByUsername(String username);

    Optional<Post> getPostById(long id);
}