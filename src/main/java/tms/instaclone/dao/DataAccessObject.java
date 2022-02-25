package tms.instaclone.dao;

import tms.instaclone.entity.Entity;
import tms.instaclone.entity.User;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();

}
