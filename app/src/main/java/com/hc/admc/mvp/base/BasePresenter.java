package com.hc.admc.mvp.base;

import com.hc.admc.mvp.basebean.IModel;
import com.hc.admc.mvp.basebean.IPresenter;
import com.hc.admc.mvp.basebean.IView;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by alex on 2017/8/3.
 */

public abstract class BasePresenter<V extends IView> implements IPresenter {
    private WeakReference actReference;
    protected V iView;

    public abstract HashMap<String, IModel> getiModelMap();

    @Override
    public void attachView(IView view) {
        actReference = new WeakReference(iView);
    }

    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }

    @Override
    public V getIView() {
        return (V) actReference.get();
    }

    /**
     * @param models
     * @return 添加多个model, 如有需要
     */
    public abstract HashMap<String, IModel> loadModelMap(IModel... models);
}
