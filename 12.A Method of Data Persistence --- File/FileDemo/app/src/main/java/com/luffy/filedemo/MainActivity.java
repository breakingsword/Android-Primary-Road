package com.luffy.filedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.txt_wirte)
    TextView txtWirte;
    @InjectView(R.id.edt_write)
    EditText edtWrite;
    @InjectView(R.id.edt_read)
    EditText edtRead;
    @InjectView(R.id.btn_pri)
    Button btnPri;
    @InjectView(R.id.btn_app)
    Button btnApp;
    @InjectView(R.id.btn_read)
    Button btnRead;
    @InjectView(R.id.txt_read)
    TextView txtRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_pri, R.id.btn_app, R.id.btn_read})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pri:
                outputFilePrivate();
                break;
            case R.id.btn_app:
                outputFileAppend();
                break;
            case R.id.btn_read:
                inputFile();
                break;
        }
    }

    public void outputFilePrivate() {
        FileOutputStream flieOS = null;
        BufferedWriter bfWriter = null;
        try {
            flieOS = openFileOutput("data2", Context.MODE_PRIVATE);
            bfWriter = new BufferedWriter(new OutputStreamWriter(flieOS));
            bfWriter.write(edtWrite.getText().toString());
            Toast.makeText(this, edtWrite.getText().toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bfWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputFileAppend() {
        FileOutputStream flieOS = null;
        BufferedWriter bfWriter = null;
        try {
            flieOS = openFileOutput("data2", Context.MODE_APPEND);
            bfWriter = new BufferedWriter(new OutputStreamWriter(flieOS));
            bfWriter.write(edtWrite.getText().toString());
            Toast.makeText(this, edtWrite.getText().toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bfWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void inputFile() {
        FileInputStream fileIS = null;
        BufferedReader bfReader = null;
        try {
            fileIS = openFileInput("data2");
            bfReader = new BufferedReader(new InputStreamReader(fileIS));
            String text = bfReader.readLine();
            edtRead.setText(text);
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bfReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
