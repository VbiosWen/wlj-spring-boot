package org.geeksword.springboot.util.model.lock;

public interface ReadWriteLock {

    Lock readLock();

    Lock writeLock();

    int getWritingWriters();

    int getWaitingWriters();

    int getReadingReaders();

    int getWaitingReaders();

    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(final boolean preferWriter){
        return new ReadWriteLockImpl(preferWriter);
    }
}
