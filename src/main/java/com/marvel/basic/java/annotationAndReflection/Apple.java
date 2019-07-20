package com.marvel.basic.java.annotationAndReflection;

public class Apple {
    @FruitProvider(id=1, name = "红富士苹果", address = "山东省")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
