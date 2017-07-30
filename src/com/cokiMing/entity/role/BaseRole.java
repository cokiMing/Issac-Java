package com.cokiMing.entity.role;

import com.cokiMing.client.Client;
import com.cokiMing.entity.effect.BaseEffect;
import com.cokiMing.param.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseRole {
    //角色名称
    protected String name;
    //坐标x
    protected int x;
    //坐标y
    protected int y;
    //上一个x坐标
    protected double originX;
    //上一个y坐标
    protected double originY;
    //速度
    protected double speed;
    //x方向速度
    protected double xSpeed;
    //y方向速度
    protected double ySpeed;
    //方向
    protected Direction direction;
    //存活标记
    protected boolean isLive = true;
    //无敌标记
    protected boolean isInvincible = false;
    //buff
    protected BaseEffect baseEffect;
    //客户端对象
    protected Client client;
    //贴图映射
    protected Map<String,Image> imageMap = new HashMap<>();

    /**
     * default constructor
     */
    public BaseRole(){

    }

    /**
     * 初始化贴图映射
     */
    protected abstract void initImageMap();

    /**
     * init constructor
     * @param x
     * @param y
     * @param client
     * @param direction
     */
    public BaseRole(int x, int y, Client client, Direction direction){
        this.x = x;
        this.y = y;
        this.client = client;
        this.direction = direction;
    }

    /**
     * 移动
     */
    protected abstract void move();

    /**
     * 绘制当前位置
     * @param graphics
     */
    protected abstract void drawCurrent(Graphics graphics);

    /**
     * 运动方向校验
     */
    protected abstract void checkDirection();
    /**
     * 绘制轨迹
     * @param graphics
     */

    public void draw(Graphics graphics){
        drawCurrent(graphics);
        move();
    }
}
