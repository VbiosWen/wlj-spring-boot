package org.geeksword.springboot.util.reflection;

import com.google.common.collect.Maps;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReflectionUtils {


    public static Map<Object, Object> getAllAnno(Object obj) throws IllegalAccessException {
        Map<Object, Object> annoMap = Maps.newHashMap();
        scanAllField(obj, annoMap);
        return annoMap;
    }

    private static void scanAllField(Object obj, Map<Object, Object> map) throws IllegalAccessException {
        if (obj == null) {
            return;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Object o = declaredField.get(obj);
            if (Objects.isNull(o)) {
                continue;
            }
            if (o instanceof Long && declaredField.isAnnotationPresent(TestAnno.class)) {
                map.put(obj, declaredField);
            } else if (o instanceof List) {
                List oList = (List) o;
                oList.forEach(o1 -> {
                    try {
                        scanAllField(o1, map);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
            } else if (o instanceof Number || o instanceof Boolean) {
                continue;
            } else if (!declaredField.getType().getSuperclass().isAssignableFrom(Object.class)) {
                scanAllField(o, map);
            }
        }
    }


    public static void main(String[] args) throws Throwable {
        Class<?> testClazz = Test.class;
        Test test = new Test();
        HashMap<String, String> map = new HashMap<>(10);

//        Method[] methods = testClazz.getMethods();
//        for (Method method : methods) {
//            method.invoke(test);
//        }

        test.sout();

        MethodType methodType = MethodType.methodType(Boolean.class, Integer.class, String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Test.class, "sout1", methodType);
        Boolean invoke = (Boolean) methodHandle.bindTo(new Test()).invoke(1,"2");
        System.out.println(invoke);
    }
}
