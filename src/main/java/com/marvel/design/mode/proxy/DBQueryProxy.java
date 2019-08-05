package com.marvel.design.mode.proxy;

/**
 * 静态代理
 */
public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQuery();
        }

        return real.request();
    }
}
