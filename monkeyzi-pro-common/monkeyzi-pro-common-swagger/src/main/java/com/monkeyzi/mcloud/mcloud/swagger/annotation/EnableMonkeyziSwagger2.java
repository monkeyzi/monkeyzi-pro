package com.monkeyzi.mcloud.mcloud.swagger.annotation;

import com.monkeyzi.mcloud.mcloud.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: 高yg
 * @date: 2018/12/23 21:34
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:接口文档自定义注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableMonkeyziSwagger2 {
}
