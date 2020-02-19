package org.geeksword.springboot.util.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionUtils {




    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> testClazz = Test.class;
        Test test = new Test();
        HashMap<String,String> map = new HashMap<>(10);

        Method[] methods = testClazz.getMethods();
        for (Method method : methods){
           method.invoke(test);
    }

        test.sout();
    }
}
