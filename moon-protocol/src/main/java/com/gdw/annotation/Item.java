package com.gdw.annotation;

import java.lang.annotation.*;

/**
 * 数据项
 *
 * @author spike
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.TYPE})
public @interface Item {
    /**
     * 数据项名称
     *
     * @return
     */
    String name();

    /**
     * 数据项编号
     *
     * @return
     */
    int fn();

    /**
     * 数据项描述
     *
     * @return
     */
    String desc() default "";

    /**
     * 排序序号
     *
     * @return
     */
    int orderIndex() default 0;
}
