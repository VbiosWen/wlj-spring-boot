package org.geeksword.springboot.util.model.future;

public interface Future<T> {

    T get() throws InterruptedException;

    boolean done();

}
