package com.iflytek.auto.mvpmodule.testdatabase.view;

/**
 * Created by yangtao on 2017/9/21.
 */

public interface IShowJsonView {
    void showLoading();
    void hideLoading();
    void loadData(String json);
}
