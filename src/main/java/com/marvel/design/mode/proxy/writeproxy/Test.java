package com.marvel.design.mode.proxy.writeproxy;

import com.marvel.design.mode.proxy.DBQuery;
import com.marvel.design.mode.proxy.IDBQuery;

public class Test {
    public static void main(String[] args) {
        IDBQuery idbQuery = new DBQuery();
        MyHandler myHandler = new MyHandler(idbQuery);
        IDBQuery proxyDBQuery = (IDBQuery)MyProxy.newProxyInstance(
                new MyClassLoader("f:\\find\\work_for_java\\src\\main\\java\\com\\marvel\\design\\mode\\proxy\\writeproxy",
                        "myproxy"),
                IDBQuery.class, myHandler);
        System.out.println(proxyDBQuery.getClass().getName());
        proxyDBQuery.request();
    }
}
