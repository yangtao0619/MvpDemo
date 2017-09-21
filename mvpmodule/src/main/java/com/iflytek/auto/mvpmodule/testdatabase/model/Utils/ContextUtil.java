package com.iflytek.auto.mvpmodule.testdatabase.model.Utils;

import android.content.Context;

/**
 * Created by yangtao on 2017/9/21.
 */

public class ContextUtil {
    private static ContextUtil contextUtil;
    private Context mContext;

    private ContextUtil() {
    }

    public static ContextUtil getInstance(){
        if(contextUtil == null){
            contextUtil = new ContextUtil();
        }
        return contextUtil;
    }

    public void initContext(Context context){
        mContext = context;
    }

    public Context getContext(){
        return mContext;
    }
}
