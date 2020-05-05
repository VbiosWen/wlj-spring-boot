package org.geeksword.springboot.util.nio;

public class SimpleSelectorKey implements SelectorKey {

    private boolean readable;

    private boolean writeable;


    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isWriteable() {
        return false;
    }

    @Override
    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    @Override
    public void setWriteable(boolean writeable) {
        this.writeable = writeable;
    }

    @Override
    public Request<?> read() {
        return null;
    }

    @Override
    public <T> void write(Response<T> response) {

    }
}
