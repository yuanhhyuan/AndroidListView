package com.hy.appui.basicview.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.hy.app.ui3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class RecyclerviewActivity extends AppCompatActivity {
    String tag = "060_RecyclerviewActivity";

    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recyclerview);

        //获取屏幕大小
        getDisplayWH();

        //设置item 对象的图片
        initDatas();
        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false));
        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //override click callback
        overrideCallback();

    }

    private void initDatas() {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.l1,
                R.drawable.l2, R.drawable.l3, R.drawable.l4, R.drawable.l5,
                R.drawable.l6, R.drawable.l7, R.drawable.l8, R.drawable.l1, R.drawable.l2, R.drawable.l3, R.drawable.l4));
    }

    private void getDisplayWH() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Log.i(tag, "屏幕尺寸1: 宽度 = " + display.getWidth() + "高度 = :" + display.getHeight());
    }

    private int mScreenWidth;
    private static final float MIN_SCALE = .95f;
    private static final float MAX_SCALE = 1.15f;
    private int mMinWidth;
    private int mMaxWidth;
    private void overrideCallback() {
        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Log.i(tag, "点击了 ：" + position);
                Toast.makeText(RecyclerviewActivity.this, position+"", Toast.LENGTH_SHORT)
                        .show();
            }
        });


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                final int childCount = recyclerView.getChildCount();
                Log.e(tag, childCount + "" + ", dx :" + dx + ", dy :" + dy);

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                Log.e(tag, "onScrollStateChanged ,  newState is :" + newState);
            }
        });
    }

}
