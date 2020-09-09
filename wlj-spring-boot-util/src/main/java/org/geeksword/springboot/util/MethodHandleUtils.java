package org.geeksword.springboot.util;

import lombok.Data;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

/**
 * @author vbiso
 * @see
 */
@Data
public class MethodHandleUtils {

    private String name;

    private String sex;

    public static void main(String[] args) throws Throwable {
        MethodHandleUtils methodHandleUtils  = new MethodHandleUtils();
        methodHandleUtils.setName("test");
        methodHandleUtils.setSex("woman");
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<? extends MethodHandleUtils> aClass = methodHandleUtils.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            MethodHandle getter = lookup.findGetter(methodHandleUtils.getClass(), field.getName(), type);
            String fileValue = (String) getter.invoke(methodHandleUtils);
            System.out.println(fileValue);
        }
    }
}
