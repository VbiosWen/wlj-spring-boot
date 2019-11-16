package org.geeksword.springboot.util.model.future;

public class FutureTask<T> implements Future<T> {

    private final Object lock = new Object();
    private T result;
    private boolean done = false;

    @Override
    public T get() throws InterruptedException {
        synchronized (lock) {
            while (!done) {
                lock.wait();
            }
            return result;
        }
    }

    protected void finish(T result) {
        synchronized (lock) {
            if (done) {
                return;
            }
            this.result = result;
            this.done = true;
            lock.notifyAll();
        }
    }


    @Override
    public boolean done() {
        return done;
    }
}
