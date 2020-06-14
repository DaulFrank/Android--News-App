package com.example.newsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewSampleAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        final List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> line1 = new HashMap<>();
        line1.put("time","11月2日");
        line1.put("description","项目用例图");
        line1.put("langIcon",R.mipmap.u33);
        data.add(line1);

        Map<String,Object> line2 = new HashMap<>();
        line2.put("time","2月15日");
        line2.put("description","难忘清秋,心灵的旅行");
        line2.put("langIcon",R.mipmap.u39);
        data.add(line2);

        Map<String,Object> line3 = new HashMap<>();
        line3.put("time","10月2日");
        line3.put("description","好吃的水煮肉,美好的记忆");
        line3.put("langIcon",R.mipmap.u45);
        data.add(line3);

        ListView listView01 = findViewById(R.id.listView01);

        SimpleAdapter adapter = new SimpleAdapter(
                this,                       // 上下文
                data,                                // 数据
                R.layout.list_item_layout,           // 适配器
                new String[]{"time","description","langIcon"},      // 相应的属性
                new int[]{R.id.time,R.id.description,R.id.langIcon} // 布局管理器对应的位置
        );

        listView01.setAdapter(adapter);

        final HashMap<String,Integer> map = new HashMap<>();
        map.put("11月2日",0);
        map.put("2月15日",1);
        map.put("10月2日",2);

        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> line = data.get(position);
                find(map.get(line.get("time").toString()));
            }
        });


    }

    public void find(int key) {
        Intent intent = new Intent(this,ContentDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("key",key);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
