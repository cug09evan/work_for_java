package com.marvel.design.mode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib动态代理
 */
public class CglibDBQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }

        return real.request();
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDBQueryInterceptor());    //指定切入器，定义代理类逻辑
        enhancer.setInterfaces(new Class[]{IDBQuery.class});    //指定实现的接口
        IDBQuery cglibProxy = (IDBQuery)enhancer.create();      //生成代理类实例

        return cglibProxy;
    }
}
