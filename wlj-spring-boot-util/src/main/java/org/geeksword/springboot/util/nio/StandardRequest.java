package org.geeksword.springboot.util.nio;

public class StandardRequest<T> implements Request<T> {

    private T body;

    private Integer futureId;


    @Override
    public T getBody() {
        return this.body;
    }

    @Override
    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public void setFutureId(Integer futureId) {
        this.futureId = futureId;
    }

    @Override
    public Integer getFutureId() {
        return futureId;
    }
}
