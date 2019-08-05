package com.marvel.popular.framework.lombok;

import lombok.NonNull;

/**
 * 判断变量不能为空的用法
 */
public class NonNullExample {
    public String name;

    public NonNullExample(@NonNull String name) {
        this.name = name;
    }
}
