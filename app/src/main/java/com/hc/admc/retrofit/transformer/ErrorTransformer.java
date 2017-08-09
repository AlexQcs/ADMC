package com.hc.admc.retrofit.transformer;

import com.hc.admc.retrofit.execption.ErrorType;
import com.hc.admc.retrofit.execption.ExceptionEngine;
import com.hc.admc.retrofit.execption.ServerException;
import com.hc.admc.mvp.base.BaseHttpResult;
import com.hc.admc.utils.LogUtils;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by alex on 2017/8/9.
 */

public class ErrorTransformer<T> implements Observable.Transformer<BaseHttpResult<T>, T> {

    private static ErrorTransformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    @Override
    public Observable<T> call(Observable<BaseHttpResult<T>> observable) {
        return observable.map(new Func1<BaseHttpResult<T>, T>() {
            @Override
            public T call(BaseHttpResult<T> result) {
                if (result == null) throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
                LogUtils.e(TAG, result.toString());
                if (result.getStatus() != ErrorType.SUCCESS)
                    throw new ServerException(result.getStatus(), result.getMessage());
                return result.getData();
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                //ExceptionEngine为处理异常的驱动器throwable
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }

    /**
     * @return 线程安全, 双层校验
     */
    public static <T> ErrorTransformer<T> getInstance() {

        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer<>();
                }
            }
        }
        return errorTransformer;

    }
}
