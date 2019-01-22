
package com.monkeyzi.mcloud.common.redis.task;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 高yg
 * @date: 2019/1/22 22:36
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */

@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class TaskAutoConfig {

    private final MonkeyziProperties monkeyziProperties;

    @Bean
    public MonkeyziAsyncTaskConfig monkeyziAsyncTaskConfig(){
        return new MonkeyziAsyncTaskConfig(monkeyziProperties);
    }
}
