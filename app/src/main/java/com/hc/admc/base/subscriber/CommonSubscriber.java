package com.hc.admc.base.subscriber;

import android.content.Context;

import com.hc.admc.retrofit.execption.ApiException;
import com.hc.admc.utils.LogUtils;
import com.hc.admc.utils.NetworkUtil;

/**
 * Created by alex on 2017/8/9.
 */

public abstract class CommonSubscriber<T> extends BaseSubscriber {

    private Context mContext;
    private static final String TAG = "CommonSubscriber";

    public CommonSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onStart() {
        if (!NetworkUtil.isNetworkAvailable(mContext)) {
            LogUtils.e(TAG, "网络不可用");
        } else {
            LogUtils.e(TAG, "网络可用");
        }
    }

    @Override
    protected void onError(ApiException e) {
        LogUtils.e(TAG, "错误信息为 " + "code:" + e.code + "   message:" + e.message);
    }

    @Override
    public void onCompleted() {
        LogUtils.e(TAG, "成功了");
    }

}
