package tms.instaclone.entitylisthandler;

import java.util.List;

public interface EntityListIterator<T> {

    int getSize() throws EntityListHandlerException;

    List<T> getPreviousEntities(int numberEntities) throws EntityListHandlerException;

    List<T> getNextEntities(int numberEntities) throws EntityListHandlerException;

    void resetIndex() throws EntityListHandlerException;
}
