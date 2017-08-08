package com.hc.admc.mvp.basebean;

/**
 * Created by alex on 2017/8/8.
 */

public interface IPresenter<V extends IView> {

    /**
     * @param view
     *         绑定
     */
    void attachView(V view);

    /**
     * 防止内存的泄漏,清除presenter与activity之间的绑定
     */
    void detachView();


    /**
     * @return 获取View
     */
    IView getIView();
}
