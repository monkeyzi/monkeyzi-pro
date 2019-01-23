package com.monkeyzi.mcloud.sys.api.feign.hystrix;

import com.monkeyzi.mcloud.sys.api.feign.TestFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: 高yg
 * @date: 2019/1/23 22:35
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Component
@Slf4j
public class TestFeignApiHystrix implements TestFeignApi {


    @Override
    public void test() {
        log.error("feign异常");
    }
}
