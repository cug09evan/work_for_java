package com.marvel.basic.java.principle;

import java.util.HashMap;
import java.util.Map;

public class HashMapPrinciple {
    public static void main(String[] args) {
        HashMap<String, Integer> subject = new HashMap<String, Integer>();
        subject.put("chinese", 128);
        subject.put("math", 108);
        subject.put("english", 118);
        subject.put("history", 45);
        subject.put("political", 79);

        for (Map.Entry<String, Integer> entry : subject.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
