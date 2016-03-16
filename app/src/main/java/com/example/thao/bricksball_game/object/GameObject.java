package com.example.thao.bricksball_game.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Thao on 02-Mar-16.
 */
public abstract class GameObject {
    protected RectF rectangle = new RectF();  // xem moi doi tuong deu la mot hinh chu nhat
    protected float dx = 0;
    protected float dy = 0;
    protected Paint paint;
    protected RectF bound;      // bien cung la hinh chu nhat
    protected Object tag;       // phan biet cac doi tuong
    protected Bitmap bitmap;

    public GameObject() {
        paint = new Paint();
    }

    public void setLeft(float left) {
        float dx = left - rectangle.left;
        rectangle.left = left;
        rectangle.right += dx;
    }

    public void setTop(float top) {
        float dy = top - rectangle.top;
        rectangle.top = top;
        rectangle.bottom += dy;
    }

    public void setWidth(float width) {
        rectangle.right = rectangle.left + width;
    }

    public void setHeigth(float heigth) {
        rectangle.bottom = rectangle.top + heigth;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public Object getTag() {
        return tag;
    }


    // cap nhat dx
    public void setDx(float dx) {

        this.dx = dx;
    }

    // cap nhat dy
    public void setDy(float dy) {

        this.dy = dy;
    }

    public void setBound(RectF bound) {

        this.bound = bound;
    }

    public abstract void init(Context context); // ve Bitmap

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, rectangle.left, rectangle.top, paint);
    }

    public void update() {
        rectangle.top += dy;
        rectangle.bottom += dy;
        rectangle.left += dx;
        rectangle.right += dx;
    }

    public void destroy() {
        bitmap.recycle();
    }

    // Kiem tra va cham
    public boolean isCollision(GameObject obj) {
        return rectangle.left <= obj.rectangle.right && rectangle.right >= obj.rectangle.left
                && rectangle.top <= obj.rectangle.bottom && rectangle.bottom >= obj.rectangle.top;
    }

    //Cham doc
    public void verticalCollision(GameObject obj) {
        if (isCollision(obj) && (obj.rectangle.top > rectangle.bottom) || isCollision(obj) && (obj.rectangle.bottom > rectangle.top)) {
            this.dy = -dy;

        }
    }

    //cham ngang
    public void horizontalCollision(GameObject obj) {
        if ((isCollision(obj) && (obj.rectangle.right > rectangle.left)) || (isCollision(obj) && (obj.rectangle.left < rectangle.right))) {
            this.dx = -dx;
        }
    }

}
