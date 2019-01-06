package com.monkeyzi.mcloud.sys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: 高yg
 * @date: 2019/1/1 19:04
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:
 */
@Data
public class User {

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(required = true,value = "姓名")
    private String userName;
    private String password;
}
