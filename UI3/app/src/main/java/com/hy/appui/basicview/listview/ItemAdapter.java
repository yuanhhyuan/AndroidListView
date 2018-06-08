package com.hy.appui.basicview.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.app.ui3.R;

import java.util.List;

/**
 原始方式,效率低
 */
public class ItemAdapter extends ArrayAdapter<ListviewItemBean> {
    String tag = "060_ItemAdapter";

    private int layoutId;

    public ItemAdapter(Context context, int layoutId, List<ListviewItemBean> list) {
        super(context, layoutId, list);
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(tag, "ItemAdapter getView called, position: " + position + ", convertView: " + convertView);

        ListviewItemBean item1 = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
        TextView textView = (TextView) view.findViewById(R.id.item_text);
        imageView.setImageResource(item1.getImgId());
        textView.setText(item1.getName());

        return view;
    }
}
