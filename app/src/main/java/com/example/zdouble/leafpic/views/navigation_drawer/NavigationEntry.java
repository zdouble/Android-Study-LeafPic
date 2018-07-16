package com.example.zdouble.leafpic.views.navigation_drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zdouble.leafpic.R;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier;
import com.mikepenz.iconics.view.IconicsImageView;

public class NavigationEntry extends LinearLayout {

    private IconicsImageView itemIcon;
    private TextView itemText;

    public NavigationEntry(Context context) {
        this(context,null);
    }

    public NavigationEntry(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public NavigationEntry(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_navigation_entry,this,true);
        itemIcon = findViewById(R.id.navigation_item_icon);
        itemText = findViewById(R.id.navigation_item_text);
        setupView(context);
        if(attrs != null){
            setupData(context,attrs);
        }
    }

    private void setupData(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationEntry);
        String iconText = typedArray.getString(R.styleable.NavigationEntry_itemIcon);
        String text = typedArray.getString(R.styleable.NavigationEntry_itemText);
        int iconColor = typedArray.getInt(R.styleable.NavigationEntry_itemIconColor,0XFFFFFFFF);
        typedArray.recycle();

        setIcon(iconText,iconColor);
        setText(text);
    }

    private void setText(String text) {
        itemText.setText(text);
    }

    private void setIcon(String iconText, int iconColor) {
        itemIcon.setIcon(new IconicsDrawable(getContext(),iconText).color(iconColor));
    }

    private void setupView(Context context) {
        setOrientation(LinearLayout.HORIZONTAL);
        setBackground(ContextCompat.getDrawable(context, R.drawable.ripple));
        setGravity(Gravity.CENTER_VERTICAL);
        
        int verticalPadding = getResources().getDimensionPixelOffset(R.dimen.nav_entry_vertical_spacing);
        int horizontalPadding = getResources().getDimensionPixelOffset(R.dimen.nav_entry_horizontal_spacing);
        setPadding(horizontalPadding,verticalPadding,horizontalPadding,verticalPadding);
    }
}
