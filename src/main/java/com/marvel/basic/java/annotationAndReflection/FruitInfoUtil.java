package com.marvel.basic.java.annotationAndReflection;

import java.lang.reflect.Field;

/**
 * fruit注解处理器
 * 使用反射原理
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitInfo = "fruit供应商信息：";
        Field[] fields = clazz.getDeclaredFields(); //通过反射获取注解信息
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                //获取注解的信息
                FruitProvider fruitProvider = (FruitProvider)field.getAnnotation(FruitProvider.class);
                strFruitInfo = "供应商编号：" + fruitProvider.id() + ", 供应商名称：" +
                        fruitProvider.name() + ", 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitInfo);
            }
        }
    }
}
