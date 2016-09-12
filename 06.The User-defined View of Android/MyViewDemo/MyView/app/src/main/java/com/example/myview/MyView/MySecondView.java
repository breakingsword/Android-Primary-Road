package com.example.myview.MyView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myview.R;


/**
 * Created by luffy on 2016/6/10.
 */
public class MySecondView extends RelativeLayout{

    private String leftText,rightText;
    private float leftTextSize,rightTextSize;
    private int leftTextColor,rightTextColor;
    private Drawable leftBackground,rightBackground;
    private TextView leftTextView,rightTextView;
    private LayoutParams LeftParams,RightParams;
    public MySecondView(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public MySecondView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.MySecondView);
        leftText=ta.getString(R.styleable.MySecondView_leftText);
        leftTextSize=ta.getDimension(R.styleable.MySecondView_leftTextSize,10);
        leftTextColor=ta.getColor(R.styleable.MySecondView_leftTextColor,0);
        leftBackground=ta.getDrawable(R.styleable.MySecondView_leftBackground);

        rightText=ta.getString(R.styleable.MySecondView_rightText);
        rightTextSize=ta.getDimension(R.styleable.MySecondView_rightTextSize,10);
        rightTextColor=ta.getColor(R.styleable.MySecondView_rightTextColor,0);
        rightBackground=ta.getDrawable(R.styleable.MySecondView_rightBackground);

        ta.recycle();

        leftTextView =(TextView)new TextView(context);
        leftTextView.setText(leftText);
        leftTextView.setTextSize(leftTextSize);
        leftTextView.setTextColor(leftTextColor);
        leftTextView.setBackground(leftBackground);

        rightTextView=(TextView)new TextView(context);
        rightTextView.setText(rightText);
        rightTextView.setTextSize(rightTextSize);
        rightTextView.setTextColor(rightTextColor);
        rightTextView.setBackground(rightBackground);

        LeftParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        LeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        RightParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        this.addView(leftTextView,LeftParams);
        this.addView(rightTextView,RightParams);
    }

    public MySecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
