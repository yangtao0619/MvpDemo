package com.iflytek.auto.mvpmodule;

import android.app.Application;

import com.iflytek.auto.mvpmodule.testdatabase.model.Utils.ContextUtil;

/**
 * Created by yangtao on 2017/9/21.
 */

public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextUtil.getInstance().initContext(getApplicationContext());
    }
}
