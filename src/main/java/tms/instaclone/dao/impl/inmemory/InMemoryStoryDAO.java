package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.StoryDAO;
import tms.instaclone.entity.Story;
import tms.instaclone.entity.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

import static tms.instaclone.entity.Story.STORY_LIFESPAN_HOURS;

public final class InMemoryStoryDAO implements StoryDAO {
    private static volatile InMemoryStoryDAO instance;
    private final Map<Long, List<Story>> dataSource = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1L);

    private InMemoryStoryDAO() {
    }

    public static InMemoryStoryDAO getInstance(){
        if (instance == null) {
            synchronized (InMemoryStoryDAO.class) {
                if (instance == null) {
                    instance = new InMemoryStoryDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean exists(Story story) {
        List<Story> userStories = dataSource.get(story.getOwner().getId());
        if (userStories != null) {
            return userStories.contains(story);
        } else {
            return false;
        }
    }

    @Override
    public boolean save(Story story) {
        story.setId(idGenerator.getAndIncrement());
        AtomicBoolean isSaved = new AtomicBoolean(false);
        dataSource.merge(story.getOwner().getId(), new ArrayList<>(List.of(story)), (oldStories, newStory) -> {
            isSaved.set(newStory.addAll(oldStories));
            return newStory;
        });
        return isSaved.get();
    }

    @Override
    public List<Story> findAll() {
        return dataSource.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Story> findAllBetween(long offset, long limit) {
        SortedSet<Story> users = new TreeSet<>(Comparator.comparing(Story::getOwner));
        List<Story> stories = dataSource.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        users.addAll(stories);
        return users.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Story> findAllByUser(User user) {
        return dataSource.get(user.getId())
                .stream()
                .filter(story -> story.getCreationDateTime().plusHours(STORY_LIFESPAN_HOURS).isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOutdatedStories() {
        dataSource.values()
                .forEach(stories -> stories.removeIf(story -> story.getCreationDateTime()
                        .plusHours(STORY_LIFESPAN_HOURS)
                        .isBefore(LocalDateTime.now())));
    }

    @Override
    public void delete(Story story) {
        List<Story> stories = dataSource.get(story.getOwner().getId());
        if (stories != null) {
            stories.remove(story);
        }
    }
}
