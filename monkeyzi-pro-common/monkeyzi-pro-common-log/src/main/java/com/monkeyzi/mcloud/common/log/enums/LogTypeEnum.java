package com.monkeyzi.mcloud.common.log.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 高yg
 * @date: 2018/12/31 17:24
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:日志类型枚举
 */
@Getter
public enum LogTypeEnum {
    /**
     * 操作日志
     */
    OPERATION_LOG("10", "操作日志"),
    /**
     * 登录日志
     */
    LOGIN_LOG("20", "登录日志"),
    /**
     * 异常日志
     */
    EXCEPTION_LOG("30", "异常日志");

    /**
     * The Type.
     */
    String type;
    /**
     * The Name.
     */
    String name;

    LogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 根据类型获取名称
     * @param type
     * @return
     */
    public static String getName(String type){
        for (LogTypeEnum ele:LogTypeEnum.values()){
            if (ele.equals(type)){
                return  ele.getName();
            }
        }
        return null;
    }

    /**
     * 根据类型获取枚举
     * @param type
     * @return
     */
    public static LogTypeEnum getEnum(String type){
        for (LogTypeEnum ele:LogTypeEnum.values()){
            if (ele.equals(type)){
                return ele;
            }
        }
        //默认返回操作日志
        return LogTypeEnum.OPERATION_LOG;
    }

    /**
     * 获取list
     * @return
     */
    public static List<Map<String,Object>> getList(){
        List<Map<String,Object>> list=new ArrayList<>();
        for (LogTypeEnum ele:LogTypeEnum.values()){
            Map<String,Object> map= new HashMap<>();
            map.put("key",ele.type);
            map.put("value",ele.name);
            list.add(map);
        }
        return list;
    }
}
