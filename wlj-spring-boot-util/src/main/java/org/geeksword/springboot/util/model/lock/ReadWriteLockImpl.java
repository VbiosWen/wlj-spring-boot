package org.geeksword.springboot.util.model.lock;

public class ReadWriteLockImpl implements ReadWriteLock {

    private boolean preferWriter;

    public ReadWriteLockImpl() {
    }

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }

    @Override
    public int getWritingWriters() {
        return 0;
    }

    @Override
    public int getWaitingWriters() {
        return 0;
    }

    @Override
    public int getReadingReaders() {
        return 0;
    }

    @Override
    public int getWaitingReaders() {
        return 0;
    }
}
