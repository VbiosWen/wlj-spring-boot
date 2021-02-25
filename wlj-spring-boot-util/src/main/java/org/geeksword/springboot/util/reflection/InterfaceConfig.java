package org.geeksword.springboot.util.reflection;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Data
public class InterfaceConfig {

    private String beanName;

    private ClassLoader classLoader;

    private Class<?> interfaceClass;

    private InterfaceProxy interfaceProxy;


    public static void main(String[] args) {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ProxyPrint proxyPrint = new ProxyPrint();
        Object proxyObj = Proxy.newProxyInstance(contextClassLoader, new Class[]{InterfaceProxy.class}, (proxy, method, args1) -> proxyPrint.print());
        InterfaceConfig interfaceConfig = new InterfaceConfig();
        interfaceConfig.setInterfaceProxy((InterfaceProxy) proxyObj);
        interfaceConfig.getInterfaceProxy().print();
    }



}
