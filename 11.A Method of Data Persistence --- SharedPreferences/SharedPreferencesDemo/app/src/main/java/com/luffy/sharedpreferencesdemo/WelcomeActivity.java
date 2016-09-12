package com.luffy.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by luffy on 2016/8/1.
 */
public class WelcomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
        String username = pref.getString("username", "");
        String password = pref.getString("password", "");
        Intent intent=new Intent();
        if(!username.equals("")&&!password.equals("")){
            intent.setClass(this,MainActivity.class);
        }else{
            intent.setClass(this,LoginActivity.class);
        }
        this.finish();
        startActivity(intent);

    }
}
