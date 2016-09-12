package com.luffy.contentproviderdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button btnContacts;

    Button btnMycontentprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        btnContacts=(Button)findViewById(R.id.btn_contacts);
        btnContacts.setOnClickListener(this);
//        btnMycontentprovider=(Button)findViewById(R.id.btn_mycontentprovider);
//        btnMycontentprovider.setOnClickListener(this);
    }


    public void onClick(View view) {
        Intent intent =new Intent();
        switch (view.getId()) {
            case R.id.btn_contacts:
                intent.setClass(MainActivity.this,ContactsActivity.class);
                startActivity(intent);
                break;
//            case R.id.btn_mycontentprovider:
//                intent.setClass(MainActivity.this,MyCpActivity.class);
//                startActivity(intent);
//                break;
        }
    }
}
