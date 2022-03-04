package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.PostDAO;
import tms.instaclone.entity.Post;
import tms.instaclone.entity.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public final class InMemoryPostDAO implements PostDAO {
    private static volatile InMemoryPostDAO instance;
    private final Map<Long, Post> dataSource = new ConcurrentHashMap<>();
    private static AtomicLong idPost = new AtomicLong(0);
    private static AtomicLong idImage = new AtomicLong(100);
    private static AtomicLong idVideo = new AtomicLong(50);

    private InMemoryPostDAO() {
    }

    public static InMemoryPostDAO getInstance() {
        if (instance == null) {
            synchronized (InMemoryPostDAO.class) {
                if (instance == null) {
                    instance = new InMemoryPostDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean exists(Post entity) {
        return false;
    }

    @Override
    public boolean save(Post post) {
        post.setId(idPost.incrementAndGet());

        return post != null && dataSource.putIfAbsent(post.getId(), post) == null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public List<Post> findAllBetween(long offset, long limit) {
        SortedSet<Post> posts = new TreeSet<>(Comparator.comparing(Post::getCreationDateTime));
        posts.addAll(dataSource.values());
        return posts.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Post> getListPostByUsername(User user) {
        List<Post> optional = dataSource.values().stream().filter(currentPost -> currentPost.getOwner().getUsername().equals(user.getUsername())).collect(Collectors.toList());
        return optional;
    }

    @Override
    public Optional<Post> getPostById(long id) {
        Optional<Post> post = dataSource.values().stream().filter(currentPost -> currentPost.getId() == id).findAny();
        return post;
    }

    public static Long getIdImage() {
        return idImage.incrementAndGet();
    }

    public static Long getIdVideo() {
        return idVideo.incrementAndGet();
    }
}