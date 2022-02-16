package tms.instaclone.dao;

import tms.instaclone.entity.Entity;

public interface DAO<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);
}
