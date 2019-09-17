package org.geeksword.springboot.redis.struct;

import java.io.Serializable;
import java.util.Objects;

/**
 * @wenliujie
 */
public class RedisString implements Serializable {

    private static final long serialVersionUID = 269463320772103756L;

    private int len;

    private int free;

    private char[] buf;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public String getBuf() {
        return String.valueOf(this.buf);
    }
    public void setBuf(String buf) {
        checkArguments(buf);
        char[] buffer = buf.toCharArray();
        this.len = buffer.length;
        this.buf = new char[buffer.length + 5];
        this.free = this.buf.length - this.len;
        System.arraycopy(this.buf,0,buffer,0,buffer.length);
    }

    public void append(String buf){
        checkArguments(buf);
        char[] buffer = buf.toCharArray();
        if(Objects.isNull(this.buf)){
            setBuf(buf);
            return;
        }

    }

    private void checkArguments(String buf) {
        if (Objects.isNull(buf)) {
            throw new IllegalArgumentException("buf must not be null.");
        }
    }
}
