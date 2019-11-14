package org.geeksword.springboot.util.serialization;

import java.io.*;
import java.util.Objects;

public class JdkSerializer implements Serializer {

    @Override
    public byte[] encode(Serializable obj) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (Objects.nonNull(byteArrayOutputStream)) {
                byteArrayOutputStream.close();
            }
            if (Objects.nonNull(objectOutputStream)) {
                objectOutputStream.close();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Serializable> T decode(byte[] bytes, Class<? extends Serializable> tClass) throws IOException,
            ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object o = objectInputStream.readObject();
            return (T) o;
        } finally {
            if (Objects.nonNull(byteArrayInputStream)) {
                byteArrayInputStream.close();
            }
            if (Objects.nonNull(objectInputStream)) {
                objectInputStream.close();
            }
        }
    }


}
