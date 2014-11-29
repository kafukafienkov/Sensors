package com.bartek.example.sensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CompassView extends View {

    private Paint paint;
    private int position = 0;

    public CompassView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4);
        paint.setTextSize(35);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int xPoint = getMeasuredWidth() / 2;
        int yPoint = getMeasuredHeight() / 2;

        float radius = (float) (Math.max(xPoint, yPoint) * 0.6);

        canvas.drawLine(xPoint, yPoint,
                (float) (xPoint - radius * Math.sin((double) (-position) / 180 * Math.PI)),
                (float) (yPoint + radius * Math.cos((double) (-position) / 180 * Math.PI)), paint);

        canvas.drawText(String.valueOf(position), xPoint, yPoint, paint);
    }

    public void updateData(int position) {
        this.position = position;
        invalidate();
    }
}
