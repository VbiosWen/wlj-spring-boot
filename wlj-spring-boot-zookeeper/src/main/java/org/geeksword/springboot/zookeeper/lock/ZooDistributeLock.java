package org.geeksword.springboot.zookeeper.lock;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * @wenliujie
 */
public class ZooDistributeLock extends AbstractZooLock {
    @Override
    protected boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    protected void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
//                if()
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };

        zkClient.subscribeDataChanges(lockPath, iZkDataListener);

        if (zkClient.exists(lockPath)) {

        }
    }


}
