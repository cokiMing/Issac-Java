package com.cokiMing.entity;

import com.cokiMing.constant.Life;

import java.util.List;

/**
 * Created by wuyiming on 2017/7/31.
 */
public class Character {
    //角色名字
    private String name;
    //角色描述
    private String description;
    //伤害值
    private double damage;
    //攻击范围
    private double range;
    //攻击频率
    private int shootRate;
    //弹速
    private double shootSpeed;
    //幸运值
    private int luck;
    //移速
    private double speed;
    //HP值
    private List<Life> lifeList;
    //主动道具
    private Item activeItem;
    //被动道具
    private List<Item> passiveItemList;
    //卡牌/胶囊
    private Item primaryItem;
    //饰品
    private Item baseOrnament;
    //硬币数量
    private int coinNum;
    //钥匙数量
    private int keyNum;
    //炸弹数量
    private int bombNum;
    //生命
    private int lives;
    //是否可以飞行
    private boolean isFlyable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getShootRate() {
        return shootRate;
    }

    public void setShootRate(int shootRate) {
        this.shootRate = shootRate;
    }

    public double getShootSpeed() {
        return shootSpeed;
    }

    public void setShootSpeed(double shootSpeed) {
        this.shootSpeed = shootSpeed;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public List<Life> getLifeList() {
        return lifeList;
    }

    public void setLifeList(List<Life> lifeList) {
        this.lifeList = lifeList;
    }

    public Item getActiveItem() {
        return activeItem;
    }

    public void setActiveItem(Item activeItem) {
        this.activeItem = activeItem;
    }

    public List<Item> getPassiveItemList() {
        return passiveItemList;
    }

    public void setPassiveItemList(List<Item> passiveItemList) {
        this.passiveItemList = passiveItemList;
    }

    public Item getPrimaryItem() {
        return primaryItem;
    }

    public void setPrimaryItem(Item primaryItem) {
        this.primaryItem = primaryItem;
    }

    public Item getBaseOrnament() {
        return baseOrnament;
    }

    public void setBaseOrnament(Item baseOrnament) {
        this.baseOrnament = baseOrnament;
    }

    public int getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(int coinNum) {
        this.coinNum = coinNum;
    }

    public int getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(int keyNum) {
        this.keyNum = keyNum;
    }

    public int getBombNum() {
        return bombNum;
    }

    public void setBombNum(int bombNum) {
        this.bombNum = bombNum;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isFlyable() {
        return isFlyable;
    }

    public void setFlyable(boolean flyable) {
        isFlyable = flyable;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage=" + damage +
                ", range=" + range +
                ", shootRate=" + shootRate +
                ", shootSpeed=" + shootSpeed +
                ", luck=" + luck +
                ", speed=" + speed +
                ", lifeList=" + lifeList +
                ", activeItem=" + activeItem +
                ", passiveItemList=" + passiveItemList +
                ", primaryItem=" + primaryItem +
                ", baseOrnament=" + baseOrnament +
                ", coinNum=" + coinNum +
                ", keyNum=" + keyNum +
                ", bombNum=" + bombNum +
                ", lives=" + lives +
                ", isFlyable=" + isFlyable +
                '}';
    }
}
