package com.monkeyzi.mcloud.sys.blog;

import com.monkeyzi.mcloud.sys.MonkeyziSysApplicationTests;
import com.monkeyzi.mcloud.sys.api.entity.BlogComm;
import com.monkeyzi.mcloud.sys.service.BlogCommService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 高yg
 * @date: 2019/1/3 22:52
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
public class BlogTests extends MonkeyziSysApplicationTests {
    @Autowired
    private BlogCommService blogCommService;

    @Test
    public void test1(){
        BlogComm comm=new BlogComm();
        //comm.setCId(1);
        comm.setComment("测试");
        blogCommService.save(comm);
    }
}
