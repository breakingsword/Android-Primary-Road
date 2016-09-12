package com.example.myview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by luffy on 2016/6/10.
 */
public class MyThindView extends View{
    private Paint mpaint =new Paint();
    public MyThindView(Context context) {
        super(context);
    }

    public MyThindView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyThindView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas) {
        mpaint.setColor(0xff03A9F4);
        mpaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < 5; i++) {
            canvas.drawRect(i * 100, i * 100, i * 100 + 100, i * 100 + 100, mpaint);
        }

    }
}
