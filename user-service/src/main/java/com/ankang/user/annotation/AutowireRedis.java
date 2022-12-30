package com.ankang.user.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
//test push 3
public @interface AutowireRedis {
    String operation() default "select";

    Class targetClass() default Boolean.class;
}
