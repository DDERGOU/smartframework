package pers.ergou.smartframework.helper;

import pers.ergou.smartframework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手
 * Created by ZDD on 2017/5/15.
 */
public class BeanHelper {

    /**
     * 定义 Bean 映射（用于存放 Bean 类和 Bean实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet){
            Object object = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, object);
        }
    }

    /**
     * 获取 Bean 映射
     */
    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     */
    public static <T> T getBean(Class<T> beanClass){
        if (!BEAN_MAP.containsKey(beanClass))
            throw new RuntimeException("can not get bean by class: " + beanClass);
        return (T) BEAN_MAP.get(beanClass);
    }
}
