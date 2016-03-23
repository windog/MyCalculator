package com.example.windy.firstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by windy on 2016/3/16.
 */
public class MeiziView extends View {
    public float bitmapX;
    public float bitmapY;

    public MeiziView(Context context){
        super(context);
        bitmapX = 0;
        bitmapY = 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.qq);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if (bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
