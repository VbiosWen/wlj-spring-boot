package org.geeksword.springboot.util.nio;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NioQueueContext {

    private volatile Queue<TransferContext> transferContexts;

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    private final SelectorKey selectorKey;

    public NioQueueContext(Queue<TransferContext> transferContexts, SelectorKey selectorKey) {
        this.transferContexts = transferContexts;
        this.selectorKey = selectorKey;
    }

    public <T,R> void putTransfer(TransferContext transferContext) {
        ReentrantLock lock = reentrantLock;
        try {
            lock.lock();
            transferContexts.add(transferContext);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void getTransfer() {
        ReentrantLock lock = reentrantLock;
        try {
            lock.lock();
            while (transferContexts.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            selectorKey.setReadable(Boolean.TRUE);
        } finally {
            reentrantLock.unlock();
        }
    }
}
