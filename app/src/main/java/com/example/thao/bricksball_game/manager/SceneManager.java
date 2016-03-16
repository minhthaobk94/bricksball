package com.example.thao.bricksball_game.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.example.thao.bricksball_game.object.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thao on 05-Mar-16.
 */
public abstract class SceneManager {
    protected RectF rectangle;
    protected Context context;
    protected List<GameObject> objects = new ArrayList<>();

    public void init(RectF rectF) {
        this.rectangle = rectF;
    }

    public SceneManager(Context context) {
        this.context = context;
    }

    public void draw(Canvas canvas) {
        for (GameObject obj : objects) {
            obj.draw(canvas);
        }
    }

    public void update(){
        for (GameObject obj : objects){
            obj.update();
        }
    }
}
