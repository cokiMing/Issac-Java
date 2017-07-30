package com.cokiMing.entity.role.character;

import com.cokiMing.entity.buff.BaseBuff;
import com.cokiMing.entity.role.BaseRole;
import com.cokiMing.param.Direction;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseCharacter extends BaseRole {
    //伤害值
    protected double damage;
    //发射方向
    protected Direction shootDirection = Direction.D;
    //键盘监听标记
    protected boolean shootL = false, shootR = false, shootU = false, shootD = false;
    //buff
    protected List<BaseBuff> buffList = new ArrayList<>(16);

    /**
     * default constructor
     */
    public BaseCharacter (){
    }

    /**
     * 键盘监听--按下
     * @param keyEvent
     */
    public abstract void keyPressed(KeyEvent keyEvent);

    /**
     * 键盘监听--松开
     * @param keyEvent
     */
    public abstract void keyReleased(KeyEvent keyEvent);

    /**
     * 获得某个buff
     * @param buff
     */
    public void addBuff(BaseBuff buff){
        buffList.add(buff);
    }
}
