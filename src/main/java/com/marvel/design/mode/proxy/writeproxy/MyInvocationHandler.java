package com.marvel.design.mode.proxy.writeproxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] inferfaces)
        throws Exception;
}
