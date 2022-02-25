package tms.instaclone.entitylisthandler;

import tms.instaclone.dao.DataAccessObject;
import tms.instaclone.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EntityListHandler<T extends Entity, R extends DataAccessObject<T>> implements EntityListIterator<T> {
    private R entityDAO;
    private List<T> entities;
    private ListIterator<T> entityListIterator;

    public EntityListHandler(R entityDAO) {
        this.entityDAO = entityDAO;
        entities = entityDAO != null ? entityDAO.findAll() : null;
        entityListIterator = entities != null ? entities.listIterator() : null;
    }

    @Override
    public int getSize() throws EntityListHandlerException {
        if (entities != null) {
            return entities.size();
        } else {
            throw new EntityListHandlerException();
        }
    }

    @Override
    public List<T> getPreviousEntities(int count) throws EntityListHandlerException {
        List<T> previousEntities;
        if (count > 0 && entities != null && entityListIterator != null) {
            previousEntities = new ArrayList<>();
            while (entityListIterator.hasPrevious() && count != 0) {
                previousEntities.add(entityListIterator.previous());
                count--;
            }
            return previousEntities;
        } else {
            throw new EntityListHandlerException();
        }
    }

    @Override
    public List<T> getNextEntities(int count) throws EntityListHandlerException {
        List<T> nextEntities;
        if (count > 0 && entities != null && entityListIterator != null) {
            nextEntities = new ArrayList<>();
            while (entityListIterator.hasNext() && count != 0) {
                nextEntities.add(entityListIterator.next());
                count--;
            }
            return nextEntities;
        } else {
            throw new EntityListHandlerException();
        }
    }

    @Override
    public void resetIndex() throws EntityListHandlerException {
        if (entityListIterator != null && entities != null) {
            entityListIterator = entities.listIterator();
        } else {
            throw new EntityListHandlerException();
        }
    }
}
