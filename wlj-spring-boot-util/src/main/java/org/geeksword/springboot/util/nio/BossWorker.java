package org.geeksword.springboot.util.nio;

public interface BossWorker {

    <T,R> Response<R> doRequest(Request<T> request);
}
