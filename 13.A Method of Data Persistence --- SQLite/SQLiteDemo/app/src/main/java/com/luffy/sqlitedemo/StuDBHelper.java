package com.luffy.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by luffy on 2016/8/6.
 */
public class StuDBHelper extends SQLiteOpenHelper {
    Context mcontext;
    private static String createStuTable="create table student(" +
            "id integer primary key autoincrement," +
            "name varchar(16)," +
            "password varchar(16))";
    private static String createTeaTable="create table teacher(" +
            "id integer primary key autoincrement," +
            "name varchar(16)," +
            "password varchar(16))";
    public StuDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createStuTable);
        Toast.makeText(mcontext,"student数据库已创建",Toast.LENGTH_SHORT).show();
        db.execSQL(createTeaTable);
        Toast.makeText(mcontext,"teacher数据库已创建",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        db.execSQL("drop table if exists teacher");
        onCreate(db);
        Toast.makeText(mcontext,"数据库已更新",Toast.LENGTH_SHORT).show();
    }
}
