package com.example.newsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteDBHelper extends SQLiteOpenHelper {
    static final String CREATE_SQL[] = {
            "CREATE TABLE news (" +
                    "_id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "title  varchar," +
                    "content  varchar," +
                    "keyword  varchar," +
                    "category  varchar," +
                    "author  INTEGER," +
                    "publish_time  varchar" +
                    ")",
            "CREATE TABLE user (" +
                    "_id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "name  varchar," +
                    "password  varchar," +
                    "email  varchar," +
                    "phone  varchar," +
                    "address  varcher" +
                    ")",
            "INSERT INTO user VALUES (1,'admin',123456,'admin@163.com',123,'洛阳')",
            "INSERT INTO user VALUES (2,'zhangsan',123,'zhangsan@163.com',123,'北京')",
    };

    public SQLiteDBHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        for (int i = 0; i < CREATE_SQL.length; i++) {
            db.execSQL(CREATE_SQL[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
