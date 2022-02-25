package tms.instaclone.dao;

import tms.instaclone.entity.Story;
import tms.instaclone.entity.User;

import java.util.List;

public interface StoryDAO extends DataAccessObject<Story> {

    List<Story> findAllByUser(User user);

    void deleteOutdatedStories();

    void delete(Story story);
}
