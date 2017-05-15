package pers.ergou.smartframework.helper;

import org.apache.commons.dbutils.handlers.MapHandler;
import pers.ergou.smartframework.annotation.Action;
import pers.ergou.smartframework.bean.Handler;
import pers.ergou.smartframework.bean.Request;
import pers.ergou.smartframework.util.ArrayUtil;
import pers.ergou.smartframework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * Created by ZDD on 2017/5/15.
 */
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历所有 Controller 类
            for (Class<?> controllerClass : controllerClassSet){
                //获取 Controller 类中定义的方法
                Method[] methods = controllerClass.getMethods();
                if (ArrayUtil.isNotEmpty(methods)){
                    //遍历所有 Controller 类中的方法
                    for (Method method : methods){
                        //判断带有Action注解的方法
                        if (method.isAnnotationPresent(Action.class)){
                            //从 Action 注解中获取 URL 映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证 URL 映射规则
                            if (mapping.matches("\\w+:/\\w*")){    //正则表达式说明：字符串需要转义，转义后的可以再转义
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) &&  array.length == 2){
                                    //获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
