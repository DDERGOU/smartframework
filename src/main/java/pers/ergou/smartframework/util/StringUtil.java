package pers.ergou.smartframework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * Created by ZDD on 2017/5/13.
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if (str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 分割字符串
     */
    public static String[] splitString(String str, String separatoerChars){
        return StringUtils.split(str, separatoerChars);
    }
}
