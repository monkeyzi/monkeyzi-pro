package com.monkeyzi.mcloud.sys.api.feign;

import com.monkeyzi.mcloud.sys.api.feign.hystrix.TestFeignApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 高yg
 * @date: 2019/1/23 22:33
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@FeignClient(name = "monkeyzi-pro-syscloud",fallback = TestFeignApiHystrix.class)
public interface TestFeignApi {

    @RequestMapping(value = "/tt")
    void  test();
}
