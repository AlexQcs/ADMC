package com.hc.admc.base.subscriber;

import com.hc.admc.retrofit.execption.ApiException;

import rx.Subscriber;

/**
 * Created by alex on 2017/8/8.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        ApiException apiException=(ApiException)e;
        onError(apiException);
    }

    protected abstract void onError(ApiException e);
}
