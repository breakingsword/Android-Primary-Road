package com.luffy.sharedpreferencesdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by luffy on 2016/6/5.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    private ImageButton back;
    private Button next_btn;
    private EditText username, password;
    String password_tx;
    Intent intent2 = new Intent();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        init();
    }

    public void init() {
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(this);
        next_btn = (Button) findViewById(R.id.next_btn);
        next_btn.setOnClickListener(this);
        username = (EditText) findViewById(R.id.username_u);
        password = (EditText) findViewById(R.id.password_p);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.next_btn:
                check();
                break;
        }
    }

    public void check() {
        Pattern pattern_user = Pattern.compile("\\d{11}");
        Matcher matcher_user = pattern_user.matcher(username.getText().toString());
        boolean user = matcher_user.matches();
        Pattern pattern_pass = Pattern.compile("\\w{8}");
        Matcher matcher_pass = pattern_pass.matcher(password.getText().toString());
        boolean pass = matcher_pass.matches();
        if (user && pass) {
            SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
            editor.putString("username", username.getText().toString());
            password_tx=password.getText().toString();
            password_tx=MD5Utils.encode(password_tx);
            editor.putString("password", password_tx);
            editor.commit();
            Toast.makeText(this, password_tx, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (!user) {
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        } else if (!pass) {
            Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
        }

    }
}