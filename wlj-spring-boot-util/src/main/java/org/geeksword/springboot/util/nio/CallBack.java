package org.geeksword.springboot.util.nio;

@FunctionalInterface
public interface CallBack<T,R> {

    Response<R> call(Request<T> request);
}
