package pers.ergou.smartframework.bean;

/**
 * 返回数据对象
 * Created by ZDD on 2017/5/15.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
