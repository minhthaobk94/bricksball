package com.example.thao.bricksball_game.manager;

import android.graphics.PointF;
import android.graphics.RectF;

import com.example.thao.bricksball_game.object.Brick;

import java.util.Random;

/**
 * Created by Thao on 05-Mar-16.
 */
public class BricksHolder {
    private static final float DEF_BRICK_WIDTH = 80.0f;
    private static final float DEF_BRICK_MARGIN = 5.0f;
    private static final float DEF_RATIO = 1.0f / 3.0f; // ti le giua chieu dai va rong cua mot vien gach
    private RectF rectHolder;
    private boolean[][] arrayHoler;
    private int countOfBrick = 0;
    private Random random = new Random(System.currentTimeMillis());

//Lay vi tri con trong
    private Index getAvailablePosition() {
        int i, j;
        do {
            i = random.nextInt(arrayHoler.length);
            j = random.nextInt(arrayHoler[0].length);
        } while (arrayHoler[i][j]);
        arrayHoler[i][j] = true;
        return new Index(i, j);
    }

// Lay toa do con trong
    private PointF getCoordFromPosition(Index index) {
        PointF pointF = new PointF();
        pointF.x = index.i * DEF_BRICK_WIDTH + (index.i + 1) * DEF_BRICK_MARGIN ;
        pointF.y = index.j * DEF_BRICK_WIDTH * DEF_RATIO + (index.j + 1) * DEF_BRICK_MARGIN;
        return pointF;
    }

    public boolean isFull() {
        return countOfBrick >= arrayHoler.length * arrayHoler[0].length;
    }

    public Brick generateBrick() {
        if (isFull())
            return null;
        Brick bricks = new Brick();
        PointF pointF = getCoordFromPosition(getAvailablePosition());
        bricks.setLeft(pointF.x);
        bricks.setTop(pointF.y);
        bricks.setWidth(DEF_BRICK_WIDTH);
        bricks.setHeigth(DEF_BRICK_WIDTH * DEF_RATIO);
        countOfBrick++;
        return bricks;
    }
//Tinh so gach
    public BricksHolder(RectF rectHolder){
        this.rectHolder = rectHolder;
        int m = (int) ((rectHolder.width() - DEF_BRICK_MARGIN) / (DEF_BRICK_WIDTH + DEF_BRICK_MARGIN)) + 1; // so gach tren 1 dong
        int n = (int) (((rectHolder.height() / 3.0f) - DEF_BRICK_MARGIN) / (DEF_BRICK_WIDTH * DEF_RATIO + DEF_BRICK_MARGIN)); //so gach theo cot
        arrayHoler = new boolean[m][n];
    }
// toa do
    private static class Index {
        public int i;
        public int j;
        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public Index() {
        }
    }
}

