package org.geeksword.springboot.util.reflection;

/**
 * @author vbiso
 * @see
 */
public class StandardClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
