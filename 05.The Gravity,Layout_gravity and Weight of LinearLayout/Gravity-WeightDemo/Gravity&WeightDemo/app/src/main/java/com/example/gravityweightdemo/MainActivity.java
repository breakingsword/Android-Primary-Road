package com.example.gravityweightdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_layout_gravity,btn_gravity, btn_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        btn_layout_gravity=(Button)findViewById(R.id.btn_layout_gravity);
        btn_gravity = (Button) findViewById(R.id.btn_gravity);
        btn_weight = (Button) findViewById(R.id.btn_weight);

        btn_gravity.setOnClickListener(MainActivity.this);
        btn_weight.setOnClickListener(MainActivity.this);
        btn_layout_gravity.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new  Intent();
        switch (v.getId()) {
            case R.id.btn_gravity:
                intent.setClass(this,GravityActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_weight:
                intent.setClass(this,LayoutWeightActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_layout_gravity:
                intent.setClass(this,LayoutGravityActivity.class);
                startActivity(intent);
                break;
        }
    }
}
