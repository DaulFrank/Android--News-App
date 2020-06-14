package com.example.newsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SQLiteLoginActivity extends AppCompatActivity {

    SQLiteDBHelper dbHelper;

    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_login);
        dbHelper = new SQLiteDBHelper(this,"sqlite.db",1);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);


    }

    public void onClick(View view) {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("user",new String[]{"name","password"}, "name=?",new String[]{username},null,null,null,"0,1");

        if(cursor.moveToNext()) {

            String dbPassword = cursor.getString(cursor.getColumnIndex("password"));

            cursor.close();
            if(password.equals(dbPassword)) {

                Intent intent = new Intent(this, ListViewSampleAdapterActivity.class);

                startActivity(intent);
                return;
            }

        }

        cursor.close();
        Toast.makeText(this,"输入信息有误！",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}
