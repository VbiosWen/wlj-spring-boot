package org.geeksword.springboot.util.nio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Dispatcher {

    private ExecutorService businessPool;

    public Dispatcher(ExecutorService businessPool) {
        this.businessPool = businessPool;
    }

    public <T, R> Future<Response<R>> execute(Request<T> request) {


        return null;
    }

}
