package com.neusoft.norm.log.annotations;

import java.lang.annotation.*;

/**
 * 作者: 张明楠 创建于 16/12/16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     *操作名称
     */
    String value() default "";
}
