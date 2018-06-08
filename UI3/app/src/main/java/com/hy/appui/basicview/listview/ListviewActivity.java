package com.hy.appui.basicview.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hy.app.ui3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Android之ListView详解http://blog.csdn.net/createchance/article/details/54616343
 */
public class ListviewActivity extends AppCompatActivity {

    String tag = "070_ListviewActivity";

    private List<ListviewItemBean> list = new ArrayList<>();
    ListView mListView;
    ItemAdapter1 itemAdapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //定义list
        initList();

        //原始适配器：ItemAdapter
        //        ItemAdapter itemAdapter = new ItemAdapter(ListviewActivity.this, R.layout.listviewitem, list);
        //        ListView listView = (ListView) findViewById(R.id.listview);
        //        listView.setAdapter(itemAdapter);

        //改进后的适配器：ItemAdapter1
        //1.Listview绑定的Activity，Activity对应的组件id
        itemAdapter1 = new ItemAdapter1(ListviewActivity.this, R.layout.item_listview, list, mListener);
        mListView = (ListView) findViewById(R.id.listview);
        //2. Listview里对应的item,通过适配器代码可知。class ItemAdapter1
        mListView.setAdapter(itemAdapter1);

        initListener();
    }

    private void initList() {
        for (int i = 0; i < 100; i++) {
            ListviewItemBean item1 = new ListviewItemBean("Item1 " + i, R.drawable.ic_launcher);
            list.add(item1);
        }
    }

    //3. Listview的响应事件。
    private void initListener() {

        //判断Listview滑动到顶部或者顶部
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0) {
                    View firstVisibleItemView = mListView.getChildAt(0);
                    if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
                        Log.v(tag, "##### 滚动到顶部 #####");
                        Toast.makeText(ListviewActivity.this, "滚动到顶部", Toast.LENGTH_SHORT).show();
                    }
                } else if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    View lastVisibleItemView = mListView.getChildAt(mListView.getChildCount() - 1);
                    if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == mListView.getHeight()) {
                        Log.v(tag, "##### 滚动到底部 ######");
                        Toast.makeText(ListviewActivity.this, "滚动到底部", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //do nothing
            }

        });

        //listView子菜单选择事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                ListviewItemBean mlistviewItemBean = list.get(arg2);
                Log.v(tag, "fruit.getName() is :" + mlistviewItemBean.getName());
                Toast.makeText(ListviewActivity.this, mlistviewItemBean.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * listView子菜单内部按钮响应点击事件
     * https://www.cnblogs.com/cheneasternsun/p/5614365.html
     */
    private ItemAdapter1.MyClickListener mListener = new ItemAdapter1.MyClickListener() {
        @Override
        public void myOnClick(int position, View v) {
            Toast.makeText(ListviewActivity.this,"listview的内部的按钮被点击了！，位置是-->" + position + ",内容是-->" + list.get(position), Toast.LENGTH_SHORT).show();

            list.remove(position);
            itemAdapter1.notifyDataSetChanged();//4、更新适配器，刷新界面
        }
    };

}

/**
 * Android之ListView详解
 * http://blog.csdn.net/createchance/article/details/54616343
 *
 *
 *
 * 1、item_listview.xml定义listview里每个显示元的view
 * 2、ListviewItemBean 定义item_listview.xml相关的model（数据）
 * 3、通过适配器将 显示元的view 加载到listview的显示元里
 * 4、Listview的响应事件
 *
 */