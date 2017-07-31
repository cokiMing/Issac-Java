package com.cokiMing.layer.bullet;

import com.cokiMing.layer.buff.BaseBuff;
import com.cokiMing.layer.role.BaseRole;
import com.cokiMing.constant.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseBullet {
    //x方向弹速
    protected int xSpeed;
    //y方向 弹速
    protected int ySpeed;
    //坐标x
    protected int x;
    //坐标y
    protected int y;
    //子弹方向
    protected Direction direction;
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
    //发射子弹的对象
    protected BaseRole baseRole;
    //图片映射
    protected Map<String,Image> imageMap = new HashMap<>();

    public BaseBullet(){

    }

    public BaseBullet(BaseRole baseRole){
        this.baseRole = baseRole;
        this.x = baseRole.getX();
        this.y = baseRole.getY();
    }

    public void init(){
        initBulletShape();
        initImageMap();
    }

    /**
     * 绘制方法
     * @param graphics
     */
    public abstract void draw(Graphics graphics);

    /**
     * 初始化贴图映射
     */
    protected abstract void initImageMap();

    /**
     * 初始化子弹形状
     */
    protected abstract void initBulletShape();
}
