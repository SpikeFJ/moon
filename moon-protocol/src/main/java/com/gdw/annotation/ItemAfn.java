package com.gdw.annotation;

import java.lang.annotation.*;

/**
 * @author spike
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.TYPE})
public @interface ItemAfn {

    int value();
}
