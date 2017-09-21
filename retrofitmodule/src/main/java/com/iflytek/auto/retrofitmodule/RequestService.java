package com.iflytek.auto.retrofitmodule;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yangtao on 2017/9/20.
 */

public interface RequestService {

    @GET("basil2style")
    Call<ResponseBody> getString();
}
