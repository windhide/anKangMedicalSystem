package com.ankang.staff.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
// test push
public @interface AutowireRedis {
    String operation() default "select";

    Class targetClass() default Boolean.class;
}
