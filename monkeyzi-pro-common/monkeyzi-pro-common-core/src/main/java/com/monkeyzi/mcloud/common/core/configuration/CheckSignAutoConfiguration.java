package com.monkeyzi.mcloud.common.core.configuration;

import com.monkeyzi.mcloud.common.core.annotation.aspect.CheckSignAspect;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 高yg
 * @date: 2019/1/2 21:23
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class CheckSignAutoConfiguration {
    @Bean
    public CheckSignAspect checkSignAspect(){
        return new CheckSignAspect();
    }
}
