package com.monkeyzi.mcloud.sys.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: 高yg
 * @date: 2019/1/3 22:32
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Data
@TableName("blog_comment")
public class BlogComm  {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer cId;
    private String comment;

}
