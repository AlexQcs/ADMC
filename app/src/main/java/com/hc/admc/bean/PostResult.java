package com.hc.admc.bean;

import java.util.ArrayList;

/**
 * Created by alex on 2017/8/9.
 */

public class PostResult<T> {
    private Object bean;
    private ArrayList<T> mList;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public ArrayList<T> getList() {
        return mList;
    }

    public void setList(ArrayList<T> list) {
        mList = list;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "bean=" + bean +
                ", mList=" + mList +
                '}';
    }
}
