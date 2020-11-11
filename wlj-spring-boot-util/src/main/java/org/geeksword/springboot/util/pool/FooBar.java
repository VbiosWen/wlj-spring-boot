package org.geeksword.springboot.util.pool;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    private final Semaphore semaphore1 = new Semaphore(1);
    private final Semaphore semaphore2 = new Semaphore(0);

    private final Lock lock = new ReentrantLock();

    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                condition2.await();
                printFoo.run();
                condition2.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                condition1.await();
                printBar.run();
                condition1.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
