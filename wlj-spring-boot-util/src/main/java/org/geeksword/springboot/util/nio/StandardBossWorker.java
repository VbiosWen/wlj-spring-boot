package org.geeksword.springboot.util.nio;

public class StandardBossWorker extends Thread implements BossWorker {

    private final Dispatcher dispatcher;

    private String DEFAULT_THREAD_NAME = "StandardBossWorker";

    public StandardBossWorker(Dispatcher dispatcher) {
        super.setName(DEFAULT_THREAD_NAME);
        this.dispatcher = dispatcher;
    }

    @Override
    public <T, R> Response<R> doRequest(Request<T> request) {
        return null;
    }

    @Override
    public void run() {

    }
}
