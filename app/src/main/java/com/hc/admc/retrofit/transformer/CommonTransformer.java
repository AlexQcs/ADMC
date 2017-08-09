package com.hc.admc.retrofit.transformer;

import com.hc.admc.mvp.base.BaseHttpResult;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alex on 2017/8/9.
 */

public class CommonTransformer<T> implements Observable.Transformer<BaseHttpResult<T>,T> {
    @Override
    public Observable<T> call(Observable<BaseHttpResult<T>> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorTransformer.<T>getInstance());
    }
}
