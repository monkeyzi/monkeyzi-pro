package com.monkeyzi.mcloud.common.core.annotation;

import java.lang.annotation.*;

/**
 * @author: 高yg
 * @date: 2019/1/2 21:13
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckSignAnnotation {
    /**
     * 是否进行签名
     * @return
     */
    boolean isCheckSign() default true;
}
