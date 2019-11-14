package org.geeksword.springboot.util.serialization;

import java.io.IOException;
import java.io.Serializable;

public interface Serializer {

    byte[] encode(Serializable obj) throws IOException;

    <T extends Serializable> T decode(byte[] bytes, Class<? extends Serializable> tClass) throws IOException,
            ClassNotFoundException;
}
