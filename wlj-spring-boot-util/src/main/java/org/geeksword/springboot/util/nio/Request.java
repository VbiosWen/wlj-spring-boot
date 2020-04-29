package org.geeksword.springboot.util.nio;

public interface Request<T> {

    T getBody();

    void setBody(T body);

    void setFutureId(Integer futureId);

    Integer getFutureId();
}
