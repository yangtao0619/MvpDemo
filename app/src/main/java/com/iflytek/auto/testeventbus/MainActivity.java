package com.iflytek.auto.testeventbus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

    private TextView tv_show;
    private Button btn_skip;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        tv_show = (TextView) findViewById(R.id.tv_show);
        btn_skip = (Button) findViewById(R.id.btn_skip);
        mContext = getApplicationContext();
        btn_skip.setOnClickListener(new View.OnClickListener() {
            private Intent mIntent;
            @Override
            public void onClick(View view) {
                mIntent = new Intent(mContext, SecondActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage eventMessage) {
        if (eventMessage != null)
            tv_show.setText(eventMessage.getMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
