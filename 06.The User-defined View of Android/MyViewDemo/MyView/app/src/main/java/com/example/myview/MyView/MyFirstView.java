package com.example.myview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by luffy on 2016/6/10.
 */
public class MyFirstView extends TextView{
    private Paint mpain;
    public MyFirstView(Context context) {
        super(context);

    }

    public MyFirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas){
        mpain=new Paint();
        mpain.setColor(Color.LTGRAY);
        mpain.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mpain);
        super.onDraw(canvas);
    }
}
