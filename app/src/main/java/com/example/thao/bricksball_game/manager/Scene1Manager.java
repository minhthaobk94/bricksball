package com.example.thao.bricksball_game.manager;

import android.content.Context;
import android.graphics.RectF;

import com.example.thao.bricksball_game.object.Ball;
import com.example.thao.bricksball_game.object.Brick;

/**
 * Created by Thao on 05-Mar-16.
 */
public class Scene1Manager extends SceneManager {
    private Ball ball;
    private Brick bricks;
    private BricksHolder bricksHolder;

    @Override
    // khoi tao
    public void init(RectF rectF) {
        super.init(rectF);

        ball.init(context);
        ball.setBound(rectF);

        bricksHolder = new BricksHolder(rectF);

        generateBricks(context); // khoi tao trong bo nho
    }

 // ve nhieu vien gach
    private void generateBricks(Context context) {
        while (!bricksHolder.isFull()){
            Brick bricks = bricksHolder.generateBrick();
            bricks.setTag("Gach");
            bricks.getTag();
            bricks.init(context); // load anh
            objects.add(bricks);
        }
    }

    public Scene1Manager(Context context) {
        super(context);

        ball = new Ball();
        ball.setDy(4);
        ball.setDx(5);
        objects.add(ball);
    }

    @Override
    public void update() {
        super.update();
    }
}
