package com.iflytek.auto.mvpmodule.testdatabase.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.iflytek.auto.mvpmodule.R;
import com.iflytek.auto.mvpmodule.testdatabase.presenter.ShowJsonPresenter;

public class ShowJsonActivity extends AppCompatActivity implements IShowJsonView {
    private TextView tv_showJson;
    private ProgressBar pb_showJson;
    private ShowJsonPresenter mShowJsonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_json);
        tv_showJson = (TextView) findViewById(R.id.tv_showJson);
        pb_showJson = (ProgressBar) findViewById(R.id.pb_showJson);
        mShowJsonPresenter = new ShowJsonPresenter(this);
        mShowJsonPresenter.loadData();
    }

    @Override
    public void showLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pb_showJson.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pb_showJson.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void loadData(final String json) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_showJson.setText(json);
            }
        });
    }

}
