package com.hy.appui.basicview.scrollview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.MainActivity1;
import com.hy.app.ui3.R;

/**

 */
public class ScrollviewActivity extends Activity {
    String tag = "070_ScrollviewActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        //简单的scrollview，直接在xml布局文件中定义
        Button view1 =  findViewById(R.id.view1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollviewActivity.this, MainActivity1.class);
                startActivity(i);
            }
        });

        //复杂的scrollview，继承ScrollView类实现
        Button view2 =  findViewById(R.id.view2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollviewActivity.this,ViewActivity2.class);
                startActivity(i);
            }
        });

    }
}
