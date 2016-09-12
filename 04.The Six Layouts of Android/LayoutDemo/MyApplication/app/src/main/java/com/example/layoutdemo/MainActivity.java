package com.example.layoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layoutdemo.LayoutActivity.AbsoluteLayoutActivity;
import com.example.layoutdemo.LayoutActivity.FrameLayoutActivity;
import com.example.layoutdemo.LayoutActivity.LinearLayoutActivity;
import com.example.layoutdemo.LayoutActivity.MyLayoutActivity;
import com.example.layoutdemo.LayoutActivity.RelativeLayoutActivity;
import com.example.layoutdemo.LayoutActivity.TableLayoutActivity;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button btn_relative,btn_linear,btn_my,btn_frame,btn_table,btn_absolute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btn_linear=(Button)findViewById(R.id.btn_linear);
        btn_relative=(Button)findViewById(R.id.btn_relative);
        btn_my=(Button)findViewById(R.id.btn_my);
        btn_frame=(Button)findViewById(R.id.btn_frame);
        btn_table=(Button)findViewById(R.id.btn_table);
        btn_absolute=(Button)findViewById(R.id.btn_absolute);

        btn_linear.setOnClickListener(this);
        btn_relative.setOnClickListener(this);
        btn_my.setOnClickListener(this);
        btn_frame.setOnClickListener(this);
        btn_table.setOnClickListener(this);
        btn_absolute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent mintent =new Intent();
        switch(v.getId()){
            case R.id.btn_linear:
                mintent.setClass(this, LinearLayoutActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_relative:
                mintent.setClass(this, RelativeLayoutActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_my:
                mintent.setClass(this, MyLayoutActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_frame:
                mintent.setClass(this, FrameLayoutActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_table:
                mintent.setClass(this, TableLayoutActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_absolute:
                mintent.setClass(this, AbsoluteLayoutActivity.class);
                startActivity(mintent);
                break;
        }
    }
}
