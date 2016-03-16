package com.example.thao.bricksball_game.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.thao.bricksball_game.R;

/**
 * Created by Thao on 02-Mar-16.
 */
public class Ball extends GameObject {

    @Override
    public void init(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar);
        bitmap = Bitmap.createScaledBitmap(bitmap,50,50,false);
        rectangle.right = rectangle.left + bitmap.getWidth();
        rectangle.bottom = rectangle.top + bitmap.getHeight();
    }

    // Xet va cham bien
    @Override
    public void update() {
        super.update();
        if(rectangle.right > bound.width()|| rectangle.left < 0){
            dx = -dx;
        }
        if(rectangle.bottom > bound.height()|| rectangle.top < 0){
            dy = -dy;
        }
    }
}
