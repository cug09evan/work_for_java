package com.marvel.design.mode.proxy.writeproxy;

import com.marvel.design.mode.proxy.IDBQuery;

import java.lang.reflect.Method;

public class MyHandler implements MyInvocationHandler {
    private IDBQuery idbQuery;

    public MyHandler(IDBQuery idbQuery) {
        this.idbQuery = idbQuery;
    }

    public Object invoke(Object proxy, Method method, Object[] inferfaces) throws Exception {
        before();
        Object invoke = method.invoke(idbQuery, null);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("before start, let's do something interesting");
    }

    private void after() {
        System.out.println("done work, let's relax");
    }
}
