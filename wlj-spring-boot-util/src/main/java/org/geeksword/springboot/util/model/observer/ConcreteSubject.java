package org.geeksword.springboot.util.model.observer;

/**
 * 具体目标类
 */
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        observerQueue.forEach(Observer::update);
    }
}
