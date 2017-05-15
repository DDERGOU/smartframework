package pers.ergou.smartframework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * Created by ZDD on 2017/5/15.
 */
public class ArrayUtil {
    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] objs){
        return !ArrayUtils.isEmpty(objs);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] objs){
        return ArrayUtils.isEmpty(objs);
    }
}
