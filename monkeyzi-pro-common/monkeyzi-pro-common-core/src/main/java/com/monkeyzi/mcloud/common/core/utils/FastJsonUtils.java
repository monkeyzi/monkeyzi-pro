package com.monkeyzi.mcloud.common.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author: 高yg
 * @date: 2019/1/1 19:34
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:fastJson 工具类
 */
@Slf4j
public class FastJsonUtils {

    public static <T> String obj2String(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String)obj : JSONObject.toJSONString(obj);
        } catch (Exception e) {
            log.warn("Parse Object to String error",e);
            return null;
        }
    }

    public static <T> String map2Str(Map map){
        if(map == null||map.isEmpty()){
            return null;
        }
        try {
            return JSON.toJSONString(map);
        } catch (Exception e) {
            log.warn("Parse map to String error",e);
            return null;
        }
    }
}
