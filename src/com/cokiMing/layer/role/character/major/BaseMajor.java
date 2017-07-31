package com.cokiMing.layer.role.character.major;

import com.cokiMing.action.Shootable;
import com.cokiMing.layer.item.active.BaseActive;
import com.cokiMing.layer.item.ornament.BaseOrnament;
import com.cokiMing.layer.item.passive.BasePassive;
import com.cokiMing.layer.item.primary.BasePrimary;
import com.cokiMing.layer.role.character.BaseCharacter;
import com.cokiMing.layer.role.character.baby.BaseBaby;
import com.cokiMing.param.Direction;
import com.cokiMing.param.Life;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseMajor extends BaseCharacter implements Shootable{

    private final static int MAX_COIN_NUM = 99;
    private final static int MAX_KEY_NUM = 99;
    private final static int MAX_BOMB_NUM = 99;
    private final static int MIN_COMMON_NUM = 0;
    private final static int MAX_LIFE_SIZE = 12;
    private final static int MAX_SPEED = 2;
    private static int MIN_SHOOT_RATE = 1;

    private final static int BODY_WIDTH = 60;
    private final static int BODY_HEIGHT = 40;
    private final static int HEAD_WIDTH = 80;
    private final static int HEAD_HEIGHT = 60;

    //射速
    protected double shootSpeed;
    //弹速
    protected double shootRate;
    //幸运值
    protected int luck;
    //射程
    protected double range;

    //硬币数量
    protected int coinNum = MIN_COMMON_NUM;
    //钥匙数量
    protected int keyNum = MIN_COMMON_NUM;
    //炸弹数量
    protected int bombNum = MIN_COMMON_NUM;

    //生命值
    protected List<Life> lifeList = new ArrayList<>(12);
    //拥有的宝宝
    protected List<BaseBaby> babyList = new ArrayList<>(16);
    //胶囊/卡牌
    protected List<BasePrimary> primaryList = new ArrayList<>(2);
    //饰品
    protected List<BaseOrnament> ornamentList = new ArrayList<>(2);
    //主动道具
    protected BaseActive activeItem;
    //被动道具
    protected List<BasePassive> passiveItemList = new ArrayList<>(16);
    //头部x坐标
    private int headX;
    //头部y坐标
    private int headY;
    //键盘监听标记
    protected boolean bL = false, bR = false, bU = false, bD = false;

    public BaseMajor(){
    }

    /**
     * 绘制人物头部、身体
     * @param graphics
     */
    @Override
    protected void drawCurrent(Graphics graphics) {
        if (!isLive){
            return;
        }

        //绘制人物身体
        switch (direction){
            case L:
                graphics.drawImage(imageMap.get("bodyL"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case LU:
                graphics.drawImage(imageMap.get("bodyLU"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case U:
                graphics.drawImage(imageMap.get("bodyU"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case RU:
                graphics.drawImage(imageMap.get("bodyRU"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case R:
                graphics.drawImage(imageMap.get("bodyR"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case RD:
                graphics.drawImage(imageMap.get("bodyRD"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case D:
                graphics.drawImage(imageMap.get("bodyD"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case LD:
                graphics.drawImage(imageMap.get("bodyLD"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
            case STOP:
                graphics.drawImage(imageMap.get("bodySTOP"),x,y,BODY_WIDTH,BODY_HEIGHT,null);break;
        }

        //绘制人物头部
        switch (shootDirection){
            case L:
                graphics.drawImage(imageMap.get("headL"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case LU:
                graphics.drawImage(imageMap.get("headLU"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case U:
                graphics.drawImage(imageMap.get("headU"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case RU:
                graphics.drawImage(imageMap.get("headRU"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case R:
                graphics.drawImage(imageMap.get("headR"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case RD:
                graphics.drawImage(imageMap.get("headRD"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case D:
                graphics.drawImage(imageMap.get("headD"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case LD:
                graphics.drawImage(imageMap.get("headLD"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
            case STOP:
                graphics.drawImage(imageMap.get("headSTOP"),headX,headY,HEAD_WIDTH,HEAD_HEIGHT,null);break;
        }
        move();
    }

    /**
     * 确定人物运动方向
     */
    @Override
    protected void checkDirection() {
        if(bL && !bU && !bR && !bD) direction = Direction.L;
        else if(bL && bU && !bR && !bD) direction =Direction.LU;
        else if(!bL && bU && !bR && !bD) direction =Direction.U;
        else if(!bL && bU && bR && !bD) direction =Direction.RU;
        else if(!bL && !bU && bR && !bD) direction =Direction.R;
        else if(!bL && !bU && bR && bD) direction =Direction.RD;
        else if(!bL && !bU && !bR && bD) direction =Direction.D;
        else if(bL && !bU && !bR && bD) direction =Direction.LD;
        else if(!bL && !bU && !bR && !bD) direction =Direction.STOP;

        if(shootL && !shootU && !shootR && !shootD) shootDirection = Direction.L;
        else if(shootL && shootU && !shootR && !shootD) shootDirection =Direction.LU;
        else if(!shootL && shootU && !shootR && !shootD) shootDirection =Direction.U;
        else if(!shootL && shootU && shootR && !shootD) shootDirection =Direction.RU;
        else if(!shootL && !shootU && shootR && !shootD) shootDirection =Direction.R;
        else if(!shootL && !shootU && shootR && shootD) shootDirection =Direction.RD;
        else if(!shootL && !shootU && !shootR && shootD) shootDirection =Direction.D;
        else if(shootL && !shootU && !shootR && shootD) shootDirection =Direction.LD;
        else if(!shootL && !shootU && !shootR && !shootD) shootDirection =Direction.STOP;
    }

    /**
     * 人物移动
     */
    @Override
    protected void move() {
        originX = x;
        originY = y;

        switch (direction){
            case L:
                x -= speed;break;
            case LU:
                x -= Math.sqrt(speed);y -= Math.sqrt(speed);break;
            case U:
                y -= speed;break;
            case RU:
                x += Math.sqrt(speed);y -= Math.sqrt(speed);break;
            case R:
                x += speed;break;
            case RD:
                x += Math.sqrt(speed);y += Math.sqrt(speed);break;
            case D:
                y += speed;break;
            case LD:
                x -= Math.sqrt(speed);y += Math.sqrt(speed);break;
            case STOP:
                break;
        }

        headX = x - 10;
        headY = y - 40;
    }

    /**
     * 按键逻辑
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                bL = true;break;
            case KeyEvent.VK_S:
                bD = true;break;
            case KeyEvent.VK_D:
                bR = true;break;
            case KeyEvent.VK_W:
                bU = true;break;
            case KeyEvent.VK_UP:
                shootU = true;break;
            case KeyEvent.VK_LEFT:
                shootL = true;break;
            case KeyEvent.VK_RIGHT:
                shootR = true;break;
            case KeyEvent.VK_DOWN:
                shootD = true;break;
        }

        checkDirection();
    }

    /**
     * 松键逻辑
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                bL = false;break;
            case KeyEvent.VK_S:
                bD = false;break;
            case KeyEvent.VK_D:
                bR = false;break;
            case KeyEvent.VK_W:
                bU = false;break;
            case KeyEvent.VK_UP:
                shootU = false;break;
            case KeyEvent.VK_LEFT:
                shootL = false;break;
            case KeyEvent.VK_RIGHT:
                shootR = false;break;
            case KeyEvent.VK_DOWN:
                shootD = false;break;
        }

        checkDirection();
    }

    /**
     * 加载所有buff
     */
    public void loadItemBuff(){

    }

    public void setLifeList(List<Life> lifeList) {
        if (lifeList.size() >= MAX_LIFE_SIZE){
            return;
        }
        this.lifeList = lifeList;
    }

    public void setSpeed(double speed){
        this.speed = speed >= MAX_SPEED ? MAX_SPEED:speed;
    }

    public void setCoinNum(int coinNum) {
        this.coinNum = coinNum >= MAX_COIN_NUM ? MAX_COIN_NUM:coinNum;
    }

    public void setKeyNum(int keyNum) {
        this.keyNum = keyNum >= MAX_KEY_NUM ? MAX_KEY_NUM:keyNum;
    }

    public void setBombNum(int bombNum) {
        this.bombNum = bombNum >= MAX_BOMB_NUM ? MAX_BOMB_NUM:bombNum;
    }

    public void setShootSpeed(double shootSpeed) {
        this.shootSpeed = shootSpeed <= MIN_COMMON_NUM ? MIN_COMMON_NUM:shootSpeed ;
    }

    public void setRange(double range) {
        this.range = range <= MIN_COMMON_NUM ? MIN_COMMON_NUM:range;
    }

    public double getShootSpeed() {
        return shootSpeed;
    }

    public double getShootRate() {
        return shootRate;
    }

    public void setShootRate(double shootRate) {
        this.shootRate = shootRate;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public double getRange() {
        return range;
    }

    public int getCoinNum() {
        return coinNum;
    }

    public int getKeyNum() {
        return keyNum;
    }

    public int getBombNum() {
        return bombNum;
    }

    public List<Life> getLifeList() {
        return lifeList;
    }

    public List<BaseBaby> getBabyList() {
        return babyList;
    }

    public void setBabyList(List<BaseBaby> babyList) {
        this.babyList = babyList;
    }

    public List<BasePrimary> getPrimaryList() {
        return primaryList;
    }

    public void setPrimaryList(List<BasePrimary> primaryList) {
        this.primaryList = primaryList;
    }

    public List<BaseOrnament> getOrnamentList() {
        return ornamentList;
    }

    public void setOrnamentList(List<BaseOrnament> ornamentList) {
        this.ornamentList = ornamentList;
    }

    public BaseActive getActiveItem() {
        return activeItem;
    }

    public void setActiveItem(BaseActive activeItem) {
        this.activeItem = activeItem;
    }

    public List<BasePassive> getPassiveItemList() {
        return passiveItemList;
    }

    public void setPassiveItemList(List<BasePassive> passiveItemList) {
        this.passiveItemList = passiveItemList;
    }
}
