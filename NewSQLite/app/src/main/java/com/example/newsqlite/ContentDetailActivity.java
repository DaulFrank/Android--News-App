package com.example.newsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        Bundle bundle = this.getIntent().getExtras();
        Integer key = bundle.getInt("key");

        Map<String,Object> map = load(key);

        ImageView langIcon = findViewById(R.id.langIcon);
        TextView  type = findViewById(R.id.type);
        TextView mood = findViewById(R.id.mood);
        TextView caption = findViewById(R.id.caption);
        TextView viewById = findViewById(R.id.content);

        langIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), (Integer) map.get("langIcons")));
        type.setText((String) map.get("types"));
        mood.setText((String) map.get("moods"));
        caption.setText((String) map.get("captions"));
        viewById.setText((String) map.get("viewByIds"));

    }

    public Map<String,Object> load(int key) {
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> line1 = new HashMap<>();

        line1.put("langIcons",R.mipmap.u33);
        line1.put("types","项目");
        line1.put("moods","By xxx");
        line1.put("captions","项目");
        line1.put("viewByIds","  又过深秋，枯瘦的空气里总是流淌着稍许萧瑟的味道。在这个静谧且肆意的季节里，我的思绪仿若这秋季光华里被吵醒的落叶，揉着惺忪的睡眼在风的纹络里茫然地漂浮着。\n" +
                "       一首落叶的礼赞，一座城市的沦落。\n" +
                "      在北方这座城市里，如果仔细观察，是可以看得见季节的转换的。匆忙的路人、街角的乞讨者、穿梭不停的车流、灯火辉煌的繁华夜景，它们即使占据了城市独有的风貌，我们也可以在抬头的瞬间，寻找到秋天的身影：一片秋高气爽的天空、一缕藏在城市温暖气流里的清冷空气、一街泛着枯容却又繁花似锦的落叶，这些都像是秋天带给我们的特色菜肴，被时光煮进了城市这口精美的大锅里。");

        data.add(line1);

        Map<String,Object> line2 = new HashMap<>();

        line2.put("langIcons",R.mipmap.u39);
        line2.put("types","风景");
        line2.put("moods","By xxx");
        line2.put("captions","难忘清秋,心灵的旅行");
        line2.put("viewByIds","  又过深秋，枯瘦的空气里总是流淌着稍许萧瑟的味道。在这个静谧且肆意的季节里，我的思绪仿若这秋季光华里被吵醒的落叶，揉着惺忪的睡眼在风的纹络里茫然地漂浮着。\n" +
                "       一首落叶的礼赞，一座城市的沦落。\n" +
                "      在北方这座城市里，如果仔细观察，是可以看得见季节的转换的。匆忙的路人、街角的乞讨者、穿梭不停的车流、灯火辉煌的繁华夜景，它们即使占据了城市独有的风貌，我们也可以在抬头的瞬间，寻找到秋天的身影：一片秋高气爽的天空、一缕藏在城市温暖气流里的清冷空气、一街泛着枯容却又繁花似锦的落叶，这些都像是秋天带给我们的特色菜肴，被时光煮进了城市这口精美的大锅里。");


        data.add(line2);
        Map<String,Object> line3 = new HashMap<>();

        line3.put("langIcons",R.mipmap.u45);
        line3.put("types","美食");
        line3.put("moods","By xxx");
        line3.put("captions","好吃的水煮肉,美好的记忆");
        line3.put("viewByIds","  又过深秋，枯瘦的空气里总是流淌着稍许萧瑟的味道。在这个静谧且肆意的季节里，我的思绪仿若这秋季光华里被吵醒的落叶，揉着惺忪的睡眼在风的纹络里茫然地漂浮着。\n" +
                "       一首落叶的礼赞，一座城市的沦落。\n" +
                "      在北方这座城市里，如果仔细观察，是可以看得见季节的转换的。匆忙的路人、街角的乞讨者、穿梭不停的车流、灯火辉煌的繁华夜景，它们即使占据了城市独有的风貌，我们也可以在抬头的瞬间，寻找到秋天的身影：一片秋高气爽的天空、一缕藏在城市温暖气流里的清冷空气、一街泛着枯容却又繁花似锦的落叶，这些都像是秋天带给我们的特色菜肴，被时光煮进了城市这口精美的大锅里。");

        data.add(line3);

        Map<String,Object> map = data.get(key);
        return map;
    }

}
