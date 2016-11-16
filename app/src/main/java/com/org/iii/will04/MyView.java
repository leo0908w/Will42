package com.org.iii.will04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("will", "onClick");
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawLine(0, 0, 200, 200, paint);
        canvas.drawCircle(100, 100, 40, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("will", "onTouchEvent");
        return super.onTouchEvent(event);

    }
}
