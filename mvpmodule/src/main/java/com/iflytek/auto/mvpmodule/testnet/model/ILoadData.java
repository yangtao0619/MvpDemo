package com.iflytek.auto.mvpmodule.testnet.model;

/**
 * Created by yangtao on 2017/9/21.
 */

public interface ILoadData {
    void getData(String httpUrl,ILoadDataListener iLoadDataListener);
}
