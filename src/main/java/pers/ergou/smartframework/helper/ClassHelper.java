package pers.ergou.smartframework.helper;

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
     * 获取应用包下所有的Service类
     */
}
