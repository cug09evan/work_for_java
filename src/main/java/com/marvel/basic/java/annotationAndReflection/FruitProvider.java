package com.marvel.basic.java.annotationAndReflection;

import java.lang.annotation.*;

/**
 * 新建水果供应商的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface FruitProvider {
    /**供应商编号**/
    public int id() default -1;
    /**供应商名称**/
    public String name() default "";
    /**供应商地址**/
    public String address() default "";
}
