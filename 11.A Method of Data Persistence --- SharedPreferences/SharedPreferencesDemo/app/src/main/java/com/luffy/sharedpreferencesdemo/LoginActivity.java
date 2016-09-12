package com.luffy.sharedpreferencesdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by luffy on 2016/6/5.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private Button login_btn;
    private EditText username_tx, password_tx;
    private TextView register_tx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init() {
        login_btn = (Button) findViewById(R.id.login);
        username_tx = (EditText) findViewById(R.id.username);
        username_tx.setText("");
        password_tx = (EditText) findViewById(R.id.password);
        password_tx.setText("");
        register_tx = (TextView) findViewById(R.id.register);

        register_tx.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        check();
    }


    public void check() {

    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent();
        switch (v.getId()) {
            case R.id.login:
                SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                String username = pref.getString("username", "");
                String password = pref.getString("password", "");

                String passwordGet=MD5Utils.encode(password_tx.getText().toString());
                if (username.equals(username_tx.getText().toString()) && password.equals(passwordGet)) {
                    intent1.setClass(LoginActivity.this, MainActivity.class);
                    startActivity(intent1);
                }else{
                    Toast.makeText(this, password, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.register:
                intent1.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
