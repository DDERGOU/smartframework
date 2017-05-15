package pers.ergou.smartframework;

import pers.ergou.smartframework.helper.BeanHelper;
import pers.ergou.smartframework.helper.ClassHelper;
import pers.ergou.smartframework.helper.ControllerHelper;
import pers.ergou.smartframework.helper.IocHelper;
import pers.ergou.smartframework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * Created by ZDD on 2017/5/15.
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(), true);
            //TODO  待测试
        }
    }
}
