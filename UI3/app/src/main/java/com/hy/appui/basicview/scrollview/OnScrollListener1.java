package com.hy.appui.basicview.scrollview;

/**
 定义用户交互事件的回调接口
 */
public interface OnScrollListener1 {

    //ScrollView item上下滑动
    void onScroll();

    void onTop();

    void onBottom();

    //ScrollView item左右滑动
//    void onScrolledToLeft();
//
//    void onScrolledToRight();

    //ScrollView item点击
}
