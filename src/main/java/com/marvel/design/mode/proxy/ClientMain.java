package com.marvel.design.mode.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 客户端
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        IDBQuery idbQuery = new DBQueryProxy();
        System.out.println(idbQuery.request());

        System.out.println(JDKDBQueryHandler.createJdkProxy().request());

        System.out.println(CglibDBQueryInterceptor.createCglibProxy().request());

        Class dbQueryProxyClazz = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), IDBQuery.class);
        //得到有参构造器
        Constructor constructor = dbQueryProxyClazz.getConstructor(InvocationHandler.class);
        //反射创建代理实例
        IDBQuery dbQueryProxyImpl = (IDBQuery)constructor.newInstance(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        dbQueryProxyImpl.request();
    }
}
