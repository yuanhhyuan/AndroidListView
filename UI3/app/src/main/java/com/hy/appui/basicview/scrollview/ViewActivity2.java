package com.hy.appui.basicview.scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hy.app.ui3.R;


/**

 */
public class ViewActivity2 extends Activity implements OnScrollListener1 {
    String tag = "070_ViewActivity2";

    LazyScrollView lazyScrollView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview1);

        //LazyScrollView初始化
        lazyScrollView = (LazyScrollView) findViewById(R.id.view1);

        lazyScrollView.setOnScrollListener(this);
    }


    @Override
    public void onTop() {
        // TODO Auto-generated method stub
        Log.d(tag,"------滚动到最上方------");
        Toast.makeText(this, "滚动到最上方", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScroll() {
        // TODO Auto-generated method stub
        Log.d(tag,"没有到最下方，也不是最上方");
        Toast.makeText(this, "没有到最下方，也不是最上方", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBottom() {
        // TODO Auto-generated method stub
        Log.d(tag,"------滚动到最下方------");
        Toast.makeText(this, "滚动到最下方", Toast.LENGTH_SHORT).show();
    }

}
