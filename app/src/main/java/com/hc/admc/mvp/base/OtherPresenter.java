package com.hc.admc.mvp.base;

import com.hc.admc.mvp.basebean.IModel;
import com.hc.admc.mvp.basebean.IPresenter;
import com.hc.admc.mvp.basebean.IView;

import java.lang.ref.WeakReference;

/**
 * Created by alex on 2017/8/9.
 */

public abstract class OtherPresenter<M extends IModel,V extends IView> implements IPresenter {

    private WeakReference actReference;
    protected V iView;
    protected M iModel;

    public M getiModel(){
        iModel=loadModel();
        return iModel;
    }

    public abstract M loadModel();

    @Override
    public void attachView(IView view) {
        actReference=new WeakReference(view);
    }

    @Override
    public void detachView() {
        if (actReference!=null){
            actReference.clear();
            actReference=null;
        }
    }

    @Override
    public V getIView() {
        return (V)actReference.get();
    }
}
