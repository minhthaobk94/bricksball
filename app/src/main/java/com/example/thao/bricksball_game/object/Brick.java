package com.example.thao.bricksball_game.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.thao.bricksball_game.R;

/**
 * Created by Thao on 05-Mar-16.
 */
public class Brick extends GameObject {
    public void init(Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.brick);
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) rectangle.width(), (int) rectangle.height(), false);
    }
}
