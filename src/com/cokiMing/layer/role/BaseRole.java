package com.cokiMing.layer.role;

import com.cokiMing.client.Client;
import com.cokiMing.layer.BaseLayer;
import com.cokiMing.layer.effect.BaseEffect;
import com.cokiMing.param.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseRole implements BaseLayer{
    //角色名称
    private String name;
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
    //发射方向
    protected Direction shootDirection;
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

    /**
     * 初始化角色
     */
    public void init(){
        initImageMap();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Direction getShootDirection() {
        return shootDirection;
    }

    public void setShootDirection(Direction shootDirection) {
        this.shootDirection = shootDirection;
    }
}
