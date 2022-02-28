package tms.instaclone.dao;

import tms.instaclone.entity.Entity;

import java.util.List;

public interface DataAccessObject<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();

    List<T> findAllBetween(long offset, long limit);
}
