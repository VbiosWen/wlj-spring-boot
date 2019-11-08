package org.geeksword.springboot.util.model.observer;

import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * 目标类
 */
public abstract class Subject {

    protected Queue<Observer> observerQueue = Queues.newLinkedBlockingQueue();

    public synchronized void attach(Observer observer){
        observerQueue.add(observer);
    }

    public synchronized void detach(Observer observer){
        observerQueue.remove(observer);
    }

    public abstract void notifyObserver();

}
