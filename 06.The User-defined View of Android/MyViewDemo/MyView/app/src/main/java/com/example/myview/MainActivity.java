package com.example.myview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myview.MyActivity.FirstActivity;
import com.example.myview.MyActivity.SecondActivity;
import com.example.myview.MyActivity.ThindActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        first=(Button)findViewById(R.id.first);
        second=(Button)findViewById(R.id.second);
        third=(Button)findViewById(R.id.third);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent();
        switch (v.getId()){

            case R.id.first:
                intent1.setClass(this, FirstActivity.class);
                startActivity(intent1);
                break;
            case R.id.second:
                intent1.setClass(this, SecondActivity.class);
                startActivity(intent1);
                break;
            case  R.id.third:
                intent1.setClass(this, ThindActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
