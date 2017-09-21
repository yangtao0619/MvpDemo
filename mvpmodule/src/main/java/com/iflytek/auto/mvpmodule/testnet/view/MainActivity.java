package com.iflytek.auto.mvpmodule.testnet.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.iflytek.auto.mvpmodule.R;
import com.iflytek.auto.mvpmodule.testdatabase.model.Utils.ContextUtil;
import com.iflytek.auto.mvpmodule.testdatabase.view.ShowJsonActivity;
import com.iflytek.auto.mvpmodule.testnet.presenter.DataPresenter;

/**
 * activity要实现的功能,进度条的显示和隐藏,结果文本的显示
 */

public class MainActivity extends AppCompatActivity implements IView{

    private DataPresenter mDataPresenter = new DataPresenter(this);
    private TextView tv_showText;
    private ProgressBar pb;
    private Button btn_SkipJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_showText = (TextView) findViewById(R.id.tv_showText);
        pb = (ProgressBar) findViewById(R.id.pb);
        btn_SkipJson = (Button) findViewById(R.id.btn_skipToJosn);
        btn_SkipJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContextUtil.getInstance().getContext(), ShowJsonActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        mDataPresenter.loadData();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showText(String text) {
        tv_showText.setText(text);
    }
}
