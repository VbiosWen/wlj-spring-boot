package org.geeksword.springboot.util.serialization;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;

@Slf4j
public class SerializationUtils {


    public static byte[] encode(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
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

    @SuppressWarnings("unchecked")
    public static <T> T decode(byte[] bytes) throws IOException, ClassNotFoundException {
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
