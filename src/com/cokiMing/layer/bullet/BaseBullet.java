package com.cokiMing.layer.bullet;

import com.cokiMing.layer.buff.BaseBuff;

import java.awt.*;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseBullet {
    //弹速
    protected int speed;
    //坐标x
    protected int x;
    //坐标y
    protected int y;
    //伤害值
    protected double damage;
    //是否可穿越障碍物
    protected boolean acrossBlock;
    //是否可穿越敌人
    protected boolean acrossEnemy;
    //子弹的加成
    protected BaseBuff baseBuff;
    //敌我区分标记
    protected boolean isGood;

    /**
     * 绘制方法
     * @param graphics
     */
    public abstract void draw(Graphics graphics);
}
