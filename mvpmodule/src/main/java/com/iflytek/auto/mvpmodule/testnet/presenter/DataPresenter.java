package com.iflytek.auto.mvpmodule.testnet.presenter;

import com.iflytek.auto.mvpmodule.testnet.model.ILoadDataImpl;
import com.iflytek.auto.mvpmodule.testnet.model.ILoadDataListener;
import com.iflytek.auto.mvpmodule.testnet.model.RequestModel;
import com.iflytek.auto.mvpmodule.testnet.view.IView;

/**
 * Created by yangtao on 2017/9/21.
 */

public class DataPresenter {

    private final ILoadDataImpl mLoadData;
    private IView mIView;

    public DataPresenter(IView iView) {
        mLoadData = new ILoadDataImpl();
        mIView = iView;
    }

    public void  loadData(){
        mIView.showLoading();
        mLoadData.getData("", new ILoadDataListener() {
            @Override
            public void onSuccess(RequestModel requestModel) {
                mIView.hideLoading();
                mIView.showText(requestModel.html_url);
            }

            @Override
            public void onFailed(String failMsg) {
                mIView.hideLoading();
            }
        });
    }
}
