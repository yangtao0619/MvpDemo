package com.iflytek.auto.mvpmodule.testnet.model;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by yangtao on 2017/9/21.
 */

public class ILoadDataImpl implements ILoadData {
    @Override
    public void getData(String httpUrl, final ILoadDataListener iLoadDataListener) {
        //实现具体的请求数据的方法
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConstant.BAEURL).build();
        RequestService requestService = retrofit.create(RequestService.class);
        Call<ResponseBody> call = requestService.getString();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                RequestModel requestModel = gson.fromJson(result, RequestModel.class);
                iLoadDataListener.onSuccess(requestModel);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                iLoadDataListener.onFailed(t.getMessage());
            }
        });
    }
}
