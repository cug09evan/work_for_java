package com.marvel.popular.framework.lombok;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 用于测试lombok提供的val功能，该功能类似于Scala的高阶语法，自动推断变量类型
 * 相当于java中的final类型修饰
 */
public class ValFunc {
    public String exampleList() {
        val list = new ArrayList<String>(); //类似于final List<String> list = ...
        list.add("Hello, World!");
        val param = list.get(0);

        return param.toLowerCase();
    }

    public String exampleMap() {
        val map = new HashMap<String, String>();
        map.put("evan", "thinker");
        map.put("marvel", "worker");
        val result = map.get("evan");
        return result.toLowerCase();
    }

    public static void main(String[] args) {
        ValFunc valFunc = new ValFunc();
        System.out.println(valFunc.exampleList());
        System.out.println(valFunc.exampleMap());
    }
}
