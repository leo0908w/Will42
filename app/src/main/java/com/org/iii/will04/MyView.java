package com.org.iii.will04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedList;

public class MyView extends View {
    private LinkedList<LinkedList<HashMap<String, Float>>> lines;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
        lines = new LinkedList<>();

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
        paint.setStrokeWidth(4);

        for (LinkedList<HashMap<String, Float>> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                float x0 = p0.get("x"), y0 = p0.get("y");
                float x1 = p1.get("x"), y1 = p1.get("y");
                canvas.drawLine(x0, y0, x1, y1, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(); float y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touchDown(x, y);
        } else if ((event.getAction() == MotionEvent.ACTION_MOVE)) {
            touchMove(x, y);
        }
        return true;
    }
    private void touchDown(float x, float y) {
        LinkedList<HashMap<String, Float>> line = new LinkedList<>();
        HashMap<String, Float> point = new HashMap<>();
        point.put("x", x); point.put("y", y);
        line.add(point);
        lines.add(line);
        invalidate();
    }
    private void touchMove(float x, float y) {
        HashMap<String, Float> point = new HashMap<>();
        point.put("x", x); point.put("y", y);
        lines.getLast().add(point);
        invalidate();
    }
    void clear() {
        lines.clear();
        invalidate();
    }
}
