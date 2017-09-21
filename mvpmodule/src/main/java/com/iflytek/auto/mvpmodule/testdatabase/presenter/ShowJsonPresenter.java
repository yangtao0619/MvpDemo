package com.iflytek.auto.mvpmodule.testdatabase.presenter;

import com.iflytek.auto.mvpmodule.testdatabase.model.IJsonLoadListener;
import com.iflytek.auto.mvpmodule.testdatabase.model.IJsonLoaderImpl;
import com.iflytek.auto.mvpmodule.testdatabase.view.IShowJsonView;

/**
 * Created by yangtao on 2017/9/21.
 */

public class ShowJsonPresenter {

    private IShowJsonView mIShowJsonView;
    private IJsonLoaderImpl mIJsonLoader;

    public ShowJsonPresenter(IShowJsonView showJsonView) {
        mIShowJsonView = showJsonView;
        mIJsonLoader = new IJsonLoaderImpl();
    }

    /**
     * 在这里调用model层的加载数据的方法
     */
    public void loadData() {
        mIShowJsonView.showLoading();
        mIJsonLoader.getData(new IJsonLoadListener() {
            @Override
            public void onSuccess(String json) {
                mIShowJsonView.hideLoading();
                mIShowJsonView.loadData(json);
            }

            @Override
            public void onFailed(String failMsg) {
                mIShowJsonView.hideLoading();
            }
        });

    }
}
