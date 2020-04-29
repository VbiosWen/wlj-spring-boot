package org.geeksword.springboot.util.nio;

public interface Response<T> {

    void setBody(T body);

    T getBody();

    void setFutureId(Integer futureId);

    Integer getFutureId();
}
