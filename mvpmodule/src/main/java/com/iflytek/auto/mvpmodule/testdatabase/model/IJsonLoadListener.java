package com.iflytek.auto.mvpmodule.testdatabase.model;

/**
 * Created by yangtao on 2017/9/21.
 */

public interface IJsonLoadListener {
    void onSuccess(String json);
    void onFailed(String failMsg);
}
