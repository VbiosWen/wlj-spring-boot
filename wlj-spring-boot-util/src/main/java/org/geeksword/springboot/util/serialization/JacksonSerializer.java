package org.geeksword.springboot.util.serialization;

import java.io.IOException;
import java.io.Serializable;

public class JacksonSerializer implements Serializer {

    @Override
    public byte[] encode(Serializable obj) throws IOException {
        return new byte[0];
    }

    @Override
    public <T extends Serializable> T decode(byte[] bytes, Class<? extends Serializable> tClass) throws IOException, ClassNotFoundException {
        return null;
    }
}
