package org.geeksword.springboot.zookeeper.lock;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;

import java.util.Objects;

/**
 * @wenliujie
 */
@Slf4j
public abstract class AbstractZooLock implements ZooLock {

    private static final String CONNECTION = "127.0.0.1:2181";

    protected ZkClient zkClient = new ZkClient(CONNECTION);

    protected String lockPath = "/lockPath";


    @Override
    public void getLock() {
        if (tryLock()) {
            log.info("成功获取锁");
        } else {
            waitLock();
        }
    }

    @Override
    public void unlock() {
        if (Objects.nonNull(zkClient)) {
            zkClient.close();
            log.warn("释放锁完毕!");
        }
    }

    protected abstract boolean tryLock();

    protected abstract void waitLock();
}
