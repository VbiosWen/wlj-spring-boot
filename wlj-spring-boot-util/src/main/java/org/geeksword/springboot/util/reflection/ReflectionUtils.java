package org.geeksword.springboot.util.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {




    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> testClazz = Test.class;
        Test test = new Test();

        Method[] methods = testClazz.getMethods();
        for (Method method : methods){
           method.invoke(test);
    }

        test.sout();
    }
}
