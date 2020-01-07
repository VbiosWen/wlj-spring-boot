package org.geeksword.springboot.util.model.lock;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface ReadWriteLock {

    Lock readLock();

    Lock writeLock();

    int getWritingWriters();

    int getWaitingWriters();

    int getReadingReaders();

    int getWaitingReaders();

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(" -> new")
    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }

    @NotNull
    @Contract("_ -> new")
    static ReadWriteLock readWriteLock(final boolean preferWriter){
        return new ReadWriteLockImpl(preferWriter);
    }
}
