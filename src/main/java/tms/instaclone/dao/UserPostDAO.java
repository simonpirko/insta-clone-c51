package tms.instaclone.dao;

import tms.instaclone.entity.UserPost;

import java.util.List;

public interface UserPostDAO extends DataAccessObject<UserPost> {

    List<UserPost> getUserPostByUsername(String username);
}
