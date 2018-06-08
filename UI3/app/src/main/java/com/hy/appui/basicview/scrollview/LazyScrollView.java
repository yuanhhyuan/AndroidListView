package com.hy.appui.basicview.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 * http://blog.csdn.net/wangjinyu501/article/details/20034259
 */
public class LazyScrollView extends ScrollView {
    private static final String tag = "070_LazyScrollView";

    private OnScrollListener1 onScrollListener;
    public void setOnScrollListener(OnScrollListener1 onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public LazyScrollView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public LazyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public LazyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub

    }

    /**
     *  滚动到底部
     */
    public void fullScrollDown(ScrollView scrollView){
        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
    }

    /**
     *  滚动到顶部
     */
    public void fullScrollUp(ScrollView scrollView){
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    /**
     * getScrollX() 就是当前view的左上角相对于母视图的左上角的X轴偏移量。假设getScrollX原始值为0，如果内容移向左边，getScrollX为正；如果内容移向右边，为负。
     * getScrollY同理。
     *
     * view.getMeasuredHeight() 获得控件的实际大小
     * getHeight view在屏幕上显示的大小
     */

    boolean isScrolledToTop;
    boolean isScrolledToBottom;
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // 这个log可以研究ScrollView的上下padding对结果的影响
        System.out.println("onScrollChanged getScrollY():" + getScrollY() + " t: " + t + " paddingTop: " + getPaddingTop());

        if (getScrollY() == 0) {
            isScrolledToTop = true;
            isScrolledToBottom = false;
            System.out.println("onScrollChanged isScrolledToTop:" + isScrolledToTop);

            if (onScrollListener != null) {
                Log.v(tag,"onScrolledToTop");
                onScrollListener.onTop();
            }

        } else if (getScrollY() + getHeight() - getPaddingTop() - getPaddingBottom() == getChildAt(0).getHeight()) {
            isScrolledToBottom = true;
            isScrolledToTop = false;
            System.out.println("onScrollChanged isScrolledToBottom:" + isScrolledToBottom);

            if (onScrollListener != null) {
                Log.v(tag,"onScrolledToBottom");
                onScrollListener.onBottom();
            }
        } else if (getScrollY() > 0 && getScrollY() < getPaddingTop() + getPaddingBottom() + getChildAt(0).getHeight() - getHeight()){
            isScrolledToTop = false;
            isScrolledToBottom = false;
            onScrollListener.onScroll();
        }
    }

}
