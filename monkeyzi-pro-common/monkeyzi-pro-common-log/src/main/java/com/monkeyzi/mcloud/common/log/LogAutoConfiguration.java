package com.monkeyzi.mcloud.common.log;

import com.monkeyzi.mcloud.common.log.aspect.LogAspect;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 高yg
 * @date: 2018/12/31 19:03
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:日志自动配置
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
