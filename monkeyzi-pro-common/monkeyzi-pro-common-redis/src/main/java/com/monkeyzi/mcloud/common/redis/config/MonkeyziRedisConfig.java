package com.monkeyzi.mcloud.common.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: 高yg
 * @date: 2018/10/14 18:42
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:Redis核心配置
 */
@Slf4j
@Configuration
@EnableCaching
/**
 *  读取配置文件yml的配置
 */

@ConfigurationProperties
public class MonkeyziRedisConfig {





    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        log.info("redis初始----------------");
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        template.setValueSerializer(stringRedisSerializer());
        template.setKeySerializer(stringRedisSerializer());
        // Hash key序列化
        template.setHashKeySerializer(stringRedisSerializer());
        // Hash value序列化
        template.setHashValueSerializer(stringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }


}
