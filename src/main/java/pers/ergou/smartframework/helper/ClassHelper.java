package pers.ergou.smartframework.helper;

import pers.ergou.smartframework.annotation.Action;
import pers.ergou.smartframework.annotation.Controller;
import pers.ergou.smartframework.annotation.Service;
import pers.ergou.smartframework.util.CastUtil;
import pers.ergou.smartframework.util.ClassUtil;
import pers.ergou.smartframework.util.PropsUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手
 * Created by ZDD on 2017/5/15.
 */
public final class ClassHelper {
    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASSE_SET;

    static {
        String baseName = ConfigHelper.getAppBasePackage();
        CLASSE_SET = ClassUtil.getClassSet(baseName);
    }

    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClasseSet(){
        return CLASSE_SET;
    }

    /**
     * 获取应用包下所有的Controller类
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASSE_SET){
            if (cls.isAnnotationPresent(Controller.class));
            classSet.add(cls);
        }
        return  classSet;
    }

    /**
     * 获取应用包下所有的Action类
     */
    public static Set<Class<?>> getActionClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASSE_SET){
            if (cls.isAnnotationPresent(Action.class));
            classSet.add(cls);
        }
        return  classSet;
    }

    /**
     * 获取应用包下所有的Service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASSE_SET){
            if (cls.isAnnotationPresent(Service.class));
            classSet.add(cls);
        }
        return  classSet;
    }

    /**
     * 获取应用包下所有的Bean类(包括：Service、Controller等)
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getControllerClassSet());
        classSet.addAll(getServiceClassSet());
        return  classSet;
    }


}
