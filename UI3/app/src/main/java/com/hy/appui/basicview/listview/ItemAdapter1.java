package com.hy.appui.basicview.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.app.ui3.R;

import java.util.List;

/**
 * 改进后的方式，节省了CPU
 */
public class ItemAdapter1 extends ArrayAdapter<ListviewItemBean> {
    String tag = "060_ItemAdapter1";
    private int layoutId;

    private MyClickListener mListener; //注：所有listview的item都共用同一个listener对象！！！

    public ItemAdapter1(Context context, int layoutId, List<ListviewItemBean> list , MyClickListener listener) {
        super(context, layoutId, list);
        this.layoutId = layoutId;

        mListener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d(tag, "ItemAdapter1 getView called, position: " + position + ", convertView: " + convertView);
        View view;
        ViewHolder viewHolder;
        ListviewItemBean item1 = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.item_img);
            viewHolder.textView = (TextView) view.findViewById(R.id.item_text);
            viewHolder.mButton = (Button) view.findViewById(R.id.item_button);
            view.setTag(viewHolder); // 通过setTag将ViewHolder和convertView绑定
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageResource(item1.getImgId());
        viewHolder.textView.setText(item1.getName());
        viewHolder.mButton.setOnClickListener(mListener);
        viewHolder.mButton.setTag(position);

        return view;
    }


    /**
     * item内部按钮用于回调的抽象类
     */
    public static abstract class MyClickListener implements View.OnClickListener {
        /**
         * 基类的onClick方法
         */
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }
        public abstract void myOnClick(int position, View v);
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
        Button mButton;
    }
}
