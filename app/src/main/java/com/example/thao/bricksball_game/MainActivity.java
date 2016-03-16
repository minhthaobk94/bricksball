package com.example.thao.bricksball_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thao.bricksball_game.manager.Scene1Manager;
import com.example.thao.bricksball_game.manager.SceneManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Surface(this));
    }

    public class Surface extends View {
        private SceneManager sceneManager;

        @Override
        protected void onDraw(Canvas canvas) {
            sceneManager.draw(canvas);
            sceneManager.update();
            invalidate();
        }

        boolean initialized = false;

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            if (!initialized) {
                sceneManager.init(new RectF(0, 0, getWidth(), getHeight()));
                initialized = true;
            }
        }

        public Surface(Context context) {
            super(context);
            sceneManager = new Scene1Manager(context);
        }
    }
}
