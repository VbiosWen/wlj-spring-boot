package org.geeksword.springboot.util.nio;

public interface SelectorKey {

    boolean isReadable();

    boolean isWriteable();

    void setReadable(boolean readable);

    void setWriteable(boolean writeable);

    Request<?> read();

    <T> void write(Response<T> response);
}
