package com.iflytek.auto.retrofitmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView tv_showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_showResult = (TextView) findViewById(R.id.tv_showResult);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BaseUrl).build();
        RequestService requestService = retrofit.create(RequestService.class);
        Call<ResponseBody> call = requestService.getString();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //这里是运行在主线程里面的,所以可以直接在这里更新ui
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_showResult.setText(result);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
