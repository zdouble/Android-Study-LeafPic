package com.example.zdouble.leafpic.views.navigation_drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;

import com.example.zdouble.leafpic.R;

public class NavigationDrawer extends ScrollView {
    public NavigationDrawer(@NonNull Context context) {
        this(context, null);
    }

    public NavigationDrawer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public NavigationDrawer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setupView();
        /**
         * 加载布局
         * https://blog.csdn.net/guolin_blog/article/details/12921889
         */
        LayoutInflater.from(context).inflate(R.layout.view_navigation_drawer,this,true);
    }

    /**
     * 设置滚动条的尺寸
     */
    private void setupView() {
        /**
         * getResources 读取系统资源
         * getDimensionPixelOffset https://blog.csdn.net/LVXIANGAN/article/details/53513945
         */
        int scrollBarSize = getResources().getDimensionPixelOffset(R.dimen.nav_drawer_scrollbar_size);
        setScrollBarSize(scrollBarSize);
    }
}
