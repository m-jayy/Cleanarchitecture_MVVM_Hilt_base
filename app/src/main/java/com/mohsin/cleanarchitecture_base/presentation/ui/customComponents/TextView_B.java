package com.mohsin.cleanarchitecture_base.presentation.ui.customComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.mohsin.cleanarchitecture_base.R;

public class TextView_B extends AppCompatTextView {

    Boolean isSpannable = false;

    public TextView_B(Context context) {
        super(context);

    }

    public TextView_B(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray ta= context.obtainStyledAttributes(attrs, R.styleable.TextView);
//        init(context,ta);
    }

    public TextView_B(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray ta= context.obtainStyledAttributes(attrs, R.styleable.TextView);
//        init(context,ta);
    }

    private void init(Context context, TypedArray taButton) {
        // setTextSize(20);

//        Typeface tf = ResourcesCompat.getFont(context, R.font.inter_bold);
//        setTypeface(tf);
//
    }
}