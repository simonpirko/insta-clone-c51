package tms.instaclone.service;

import tms.instaclone.dao.PostDAO;
import tms.instaclone.dao.impl.inmemory.InMemoryPostDAO;
import tms.instaclone.entity.Post;

import java.util.List;
import java.util.Optional;


public final class PostService {
    private static volatile PostService instance;
    private final PostDAO postDAO = InMemoryPostDAO.getInstance();

    private PostService() {
    }

    public static PostService getInstance(){
        if (instance == null) {
            synchronized (PostService.class) {
                if (instance == null) {
                    instance = new PostService();
                }
            }
        }
        return instance;
    }

    public boolean save(Post post) {
        return !postDAO.exists(post) && postDAO.save(post);
    }

    public List<Post> getListPostByUsername(String username){
        return postDAO.getListPostByUsername(username);
    }

    public Optional<Post> getPostById(long id) {
        return postDAO.getPostById(id);
    }
}