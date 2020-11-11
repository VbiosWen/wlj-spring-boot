package org.geeksword.springboot.util.pool;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wenliujie
 */
public class SeqProcessor {


    class Foo {
        private final Semaphore semaphore1 = new Semaphore(1);
        private final Semaphore semaphore2 = new Semaphore(0);
        private final Semaphore semaphore3 = new Semaphore(0);


        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            semaphore1.acquire();
            printFirst.run();
            semaphore2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            semaphore2.acquire();
            printSecond.run();
            semaphore3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            semaphore3.acquire();
            printThird.run();
            semaphore1.release();
        }
    }

    class Foo1 {
        private int num = 1;
        private final Object lock = new Object();

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                while (num != 1) {
                    lock.wait();
                }
                num++;
                printFirst.run();
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (lock) {
                while (num != 2) {
                    lock.wait();
                }
                num++;
                printSecond.run();
                lock.notifyAll();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (num != 3) {
                    lock.wait();
                }
                num++;
                printThird.run();
                lock.notifyAll();
            }

        }
    }

    class Foo2 {
        private final Lock lock = new ReentrantLock();
        private final Condition condition1 = lock.newCondition();
        private final Condition condition2= lock.newCondition();
        private final Condition condition3 = lock.newCondition();

        private int num = 1;



        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (num != 1){
                    condition1.await();
                }
                num++;
                printFirst.run();
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (num != 2){
                    condition2.await();
                }
                num++;
                printSecond.run();
                condition3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            lock.lock();
            try {
                while (num != 3){
                    condition3.await();
                }
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }
}
