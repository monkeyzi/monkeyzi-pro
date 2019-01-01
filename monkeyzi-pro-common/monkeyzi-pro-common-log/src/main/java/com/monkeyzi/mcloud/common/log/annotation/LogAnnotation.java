package com.monkeyzi.mcloud.common.log.annotation;

import com.monkeyzi.mcloud.common.log.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * @author: 高yg
 * @date: 2018/12/31 17:20
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:系统日志注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /**
     * 作用说明
     * @return
     */
    String description() default "";

    /**
     * 日志类型，默认操作日志
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;


    /**
     * 是否保存请求参数
     * @return
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应参数
     * @return
     */
    boolean isSaveResponseData() default true;

}
