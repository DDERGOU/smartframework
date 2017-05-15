package pers.ergou.smartframework.bean;

import pers.ergou.smartframework.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by ZDD on 2017/5/15.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取 long 型参数值
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 根据参数名获取 int 型参数值
     */
    public int getInt(String name){
        return CastUtil.castInt(paramMap.get(name));
    }

    /**
     * 根据参数名获取 double 型参数值
     */
    public Double getDouble(String name){
        return CastUtil.castDouble(paramMap.get(name));
    }

    /**
     * 根据参数名获取 String 型参数值
     */
    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }

    /**
     * 根据参数名获取 boolean 型参数值
     */
    public boolean getBoolean(String name){
        return CastUtil.castBoolean(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap(){
        return paramMap;
    }
}
