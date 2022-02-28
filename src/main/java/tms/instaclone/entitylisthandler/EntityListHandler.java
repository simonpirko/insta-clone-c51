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
    private long offset;
    private static final int LOAD_FACTOR = 3;

    public EntityListHandler(R entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public int getSize() throws EntityListHandlerException {
        if (entities != null) {
            return entities.size();
        } else {
            return 0;
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
        if (entities == null || !entityListIterator.hasNext()) {
            entities = entityDAO.findAllBetween(offset, (long) count * LOAD_FACTOR + offset);
            entityListIterator = entities != null ? entities.listIterator() : null;
        }

        List<T> nextEntities;
        if (count > 0 && entities != null && entityListIterator != null) {
            nextEntities = new ArrayList<>();
            while (entityListIterator.hasNext() && count != 0) {
                nextEntities.add(entityListIterator.next());
                count--;
                offset++;
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
        }
    }
}
