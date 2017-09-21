package com.iflytek.auto.mvpmodule.testdatabase.model;

import android.os.SystemClock;

import com.iflytek.auto.mvpmodule.testdatabase.model.Utils.ContextUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yangtao on 2017/9/21.
 */

public class IJsonLoaderImpl implements IJsonDataLoader {
    @Override
    public void getData(final IJsonLoadListener jsonLoadListener) {
        //在这里进行文件的读取
        new Thread() {
            @Override
            public void run() {
                InputStream jsonIs = ContextUtil.getInstance().getContext().getClassLoader().getResourceAsStream("assets/data.json");
                byte[] b = new byte[1024];
                int byteCount = 0;
                StringBuilder sb = new StringBuilder();
                try {
                    while ((byteCount = jsonIs.read(b)) != -1) {
                        sb.append(new String(b, 0, byteCount));
                    }
                    jsonIs.close();
                    SystemClock.sleep(2000);
                    jsonLoadListener.onSuccess(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    jsonLoadListener.onFailed("get data fail! msg is " + e.getMessage());
                }
            }
        }.start();
    }
}
