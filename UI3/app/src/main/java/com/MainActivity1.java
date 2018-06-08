package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.app.ui3.R;
import com.hy.appui.basicview.gridview.GridviewActivity;
import com.hy.appui.basicview.listview.ListviewActivity;
import com.hy.appui.basicview.recyclerview.RecyclerviewActivity;
import com.hy.appui.basicview.scrollview.ScrollviewActivity;
import com.hy.lib.SuperSwipeRefreshLayout.RecyclerViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity标准形式
 *
 */
public class MainActivity1 extends AppCompatActivity {

    @BindView(R.id.mSuperSwipeRefreshLayout)
    Button mSuperSwipeRefreshLayout;
    @BindView(R.id.mlistview)
    Button mlistview;
    @BindView(R.id.mgridview)
    Button mgridview;
    @BindView(R.id.scrollview)
    Button scrollview;
    @BindView(R.id.mRecyclerviewActivity)
    Button mRecyclerviewActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mSuperSwipeRefreshLayout,R.id.mlistview,R.id.mgridview,R.id.scrollview,R.id.mRecyclerviewActivity})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mSuperSwipeRefreshLayout:
                new1();
                break;
            case R.id.mlistview:
                newListviewActivity();
                break;
            case R.id.mgridview:
                newGridviewActivity();
                break;
            case R.id.scrollview:
                newScrollviewActivity();
                break;
            case R.id.mRecyclerviewActivity:
                newRecyclerviewActivity();
                break;
            default:
                break;
        }
    }

    /**
     * 下拉刷新，上拉加载
     * */
    private void new1(){
        Intent i = new Intent(MainActivity1.this,RecyclerViewActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    private void newListviewActivity(){
        Intent i = new Intent(MainActivity1.this,ListviewActivity.class);
        startActivity(i);
    }
    private void newGridviewActivity(){
        Intent i = new Intent(MainActivity1.this,GridviewActivity.class);
        startActivity(i);
    }
    private void newScrollviewActivity(){
        Intent i = new Intent(MainActivity1.this,ScrollviewActivity.class);
        startActivity(i);
    }
    private void newRecyclerviewActivity(){
        Intent i = new Intent(MainActivity1.this,RecyclerviewActivity.class);
        startActivity(i);
    }

}
