package com.iflytek.auto.testeventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    private Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_post = (Button) findViewById(R.id.btn_postMsg);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new EventMessage("this is a msg from second activity!"));
            }
        });
    }
}
