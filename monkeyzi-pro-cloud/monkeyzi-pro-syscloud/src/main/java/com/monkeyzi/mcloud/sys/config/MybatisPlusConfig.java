package com.monkeyzi.mcloud.sys.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 高yg
 * @date: 2019/1/3 22:19
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:mybatis plus配置
 */
@Configuration
@MapperScan("com.monkeyzi.mcloud.sys.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
