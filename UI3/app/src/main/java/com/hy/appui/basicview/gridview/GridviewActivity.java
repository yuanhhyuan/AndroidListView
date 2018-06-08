package com.hy.appui.basicview.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.hy.app.ui3.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 使用GridView和SimpleAdapter实现手机界面常见的九宫格
 https://www.cnblogs.com/zhoushasha/p/6828147.html
 */
public class GridviewActivity extends AppCompatActivity {
    private GridView mGridView;

    private int[] imageRes = {R.drawable.add, R.drawable.add,
            R.drawable.add, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.search, R.drawable.search, R.drawable.search};
    private String[] itemName = {"图1", "图2", "图3", "图4", "图5 ", "图6", "图7 ", "图8", "图9"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        mGridView = (GridView) findViewById(R.id.MyGridView);

        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

        int length = itemName.length;

        for (int i = 0; i < length; i++) {

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImageView", imageRes[i]);
            map.put("ItemTextView", itemName[i]);

            data.add(map);

        }

        //为mGridView添加适配器SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(GridviewActivity.this,
                data, R.layout.item_gridview, new String[]{"ItemImageView", "ItemTextView"},
                new int[]{R.id.ItemImageView, R.id.ItemTextView});

        mGridView.setAdapter(simpleAdapter);

        //为mGridView添加点击事件监听器
        mGridView.setOnItemClickListener(new GridViewItemOnClick());

    }

    //定义点击事件监听器
    public class GridViewItemOnClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
            Toast.makeText(getApplicationContext(), position + "",Toast.LENGTH_SHORT).show();
        }
    }

}

/**

 使用GridView和SimpleAdapter实现手机界面常见的九宫格
 https://www.cnblogs.com/zhoushasha/p/6828147.html

 1.layout
 activity_gridview.xml
 item_gridview.xml

 2.为mGridView添加适配器SimpleAdapter

 3.为mGridView添加点击事件监听器

 */