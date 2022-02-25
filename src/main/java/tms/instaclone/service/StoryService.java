package tms.instaclone.service;

import tms.instaclone.dao.StoryDAO;
import tms.instaclone.dao.impl.inmemory.InMemoryStoryDAO;
import tms.instaclone.entity.Story;
import tms.instaclone.entity.User;

import java.util.List;

public class StoryService {
    private static volatile StoryService instance;
    private final StoryDAO storyDAO = InMemoryStoryDAO.getInstance();

    private StoryService() {
    }

    public static StoryService getInstance(){
        if (instance == null) {
            synchronized (StoryService.class) {
                if (instance == null) {
                    instance = new StoryService();
                }
            }
        }
        return instance;
    }

    public boolean save(Story story) {
        return !storyDAO.exists(story) && storyDAO.save(story);
    }

    public List<Story> findAllByUser(User user) {
        if (user == null ) {
            return storyDAO.findAllByUser(user);
        }
    }
}
