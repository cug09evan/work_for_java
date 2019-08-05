package com.marvel.design.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk原生态的动态代理
 */
public class JDKDBQueryHandler implements InvocationHandler {
    IDBQuery real = null;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }

        return real.request();
    }

    public static IDBQuery createJdkProxy() {
        IDBQuery jdkProxy = (IDBQuery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JDKDBQueryHandler());
        return jdkProxy;
    }
}
