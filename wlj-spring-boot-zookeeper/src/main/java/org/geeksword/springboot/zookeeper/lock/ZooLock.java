package org.geeksword.springboot.zookeeper.lock;

/**
 * @wenliujie
 */
public interface ZooLock {

    /**
     * 获取锁
     */
    void getLock();

    /**
     * 释放锁
     */

    void unlock();


}
