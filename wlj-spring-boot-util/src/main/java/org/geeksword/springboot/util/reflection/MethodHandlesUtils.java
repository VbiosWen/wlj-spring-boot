package org.geeksword.springboot.util.reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class MethodHandlesUtils {


    public static void main(String[] args) throws Throwable {
        long start = Instant.now().toEpochMilli();
        invokeNew();
        System.out.println("cost time -------> " + (Instant.now().toEpochMilli() - start));
        Long start0= Instant.now().toEpochMilli();
        invoke();
        System.out.println("cost tine -------> " + (Instant.now().toEpochMilli() - start));
    }

    public static void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 100000; i++) {
            TestBean testBean = new TestBean();
            testBean.setIds(Arrays.asList(1,23,4));
            testBean.setName("小时");
            Class<? extends TestBean> aClass = testBean.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String name = declaredField.getName();
                String methodName = "get" + name.substring(0,1).toUpperCase() + name.substring(1);
                Method declaredMethod = aClass.getDeclaredMethod(methodName);
                Object invoke = declaredMethod.invoke(testBean);
               // System.out.println(invoke);
            }
        }
    }

    private static void invokeNew() throws Throwable {
        for (int i = 0; i < 100000; i++) {
            TestBean testBean = new TestBean();
            testBean.setIds(Arrays.asList(1,23,4));
            testBean.setName("小时");
            Class<? extends TestBean> aClass = testBean.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            MethodHandles.Lookup lookup = MethodHandles.lookup();

            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                MethodHandle getter = lookup.unreflectGetter(declaredField);
                Object invoke = getter.invoke(testBean);
                //System.out.println(invoke);
            }
        }
    }


    public static class TestBean{
        private String name;

        private List<Integer> ids;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getIds() {
            return ids;
        }

        public void setIds(List<Integer> ids) {
            this.ids = ids;
        }
    }
}
