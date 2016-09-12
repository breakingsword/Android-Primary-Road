package com.luffy.bcreceiverdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnNormalBr;
    Button btnOrderedBr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //最早注册的优先级越高
        MyBroadcastReceiver oReceiver=new MyBroadcastReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.app.nbc.test");
        this.registerReceiver(oReceiver,filter);
        init();
    }

    public void init(){
        btnNormalBr=(Button)findViewById(R.id.btn_normal_br);
        btnNormalBr.setOnClickListener(this);
        btnOrderedBr=(Button)findViewById(R.id.btn_ordered_br);
        btnOrderedBr.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal_br:
                Intent intent = new Intent("com.app.nbc.test");
                Log.i("receiver","start");
                sendBroadcast(intent);
                break;
            case R.id.btn_ordered_br:
                Intent intent2 = new Intent("com.app.bc.test");
                sendOrderedBroadcast(intent2,null);
                break;
        }
    }
}
