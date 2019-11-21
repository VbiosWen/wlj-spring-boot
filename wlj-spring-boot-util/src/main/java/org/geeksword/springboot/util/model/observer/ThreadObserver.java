package org.geeksword.springboot.util.model.observer;

public interface ThreadObserver {

    enum Cycle {
        STARTED, RUNNING, DONE, ERROR;
    }

    Cycle getCycle();

    void start();

    void interrupt();


}
