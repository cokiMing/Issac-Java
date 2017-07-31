package com.cokiMing.client;

import com.cokiMing.layer.block.BaseBlock;
import com.cokiMing.layer.bullet.BaseBullet;
import com.cokiMing.layer.curse.BaseCurse;
import com.cokiMing.layer.effect.BaseEffect;
import com.cokiMing.layer.item.BaseItem;
import com.cokiMing.layer.role.character.major.BaseMajor;
import com.cokiMing.layer.role.character.major.MajorFactory;
import com.cokiMing.layer.role.enemy.BaseEnemy;
import com.cokiMing.layer.room.BaseRoom;
import com.cokiMing.param.CommonParam;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Coki on 2017/7/30.
 */
public class Client extends Frame{

    private BaseMajor character;
    private BaseRoom baseRoom;
    private java.util.List<BaseBullet> bulletList = new ArrayList<>();
    private java.util.List<BaseItem> itemList = new ArrayList<>();
    private java.util.List<BaseEnemy> enemyList = new ArrayList<>();
    private java.util.List<BaseBlock> blockList = new ArrayList<>();
    private java.util.List<BaseEffect> effectList = new ArrayList<>();
    private java.util.List<BaseCurse> curseList = new ArrayList<>();

//    Image OffScreenImage = null;

    @Override
    public void paint(Graphics graphics){
        character.draw(graphics);
        for (BaseBullet bullet: bulletList){
            bullet.draw(graphics);
        }
    }

    /* @Override
    public void update(Graphics g) {
        super.update(g);
        if(OffScreenImage == null){
            OffScreenImage = this.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        Graphics goffscrenn = OffScreenImage.getGraphics();
        Color c = goffscrenn.getColor();
        goffscrenn.setColor(Color.black);
        goffscrenn.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        goffscrenn.setColor(c);
        g.drawImage(OffScreenImage, 0, 0, null);
        paint(goffscrenn);
     } */

    public void launch(){
        character = MajorFactory.createCharacter(MajorFactory.CHARACTER_ISSAC,this);

        this.setLocation(300,50);
        this.setSize(CommonParam.WINDOW_WIDTH,CommonParam.WINDOW_HEIGHT);
        this.setTitle("The Binding Of Issac");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.BLACK);
        this.addKeyListener(new KeyMonitor());
        setVisible(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    repaint();
                    try{
                        Thread.sleep(20);
                    }catch (Exception e){

                    }
                }
            }
        };

        new Thread(runnable).start();
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent keyEvent){
            character.keyReleased(keyEvent);
        }

        @Override
        public void keyPressed(KeyEvent keyEvent){
            character.keyPressed(keyEvent);
        }
    }

    public BaseRoom getBaseRoom() {
        return baseRoom;
    }

    public void setBaseRoom(BaseRoom baseRoom) {
        this.baseRoom = baseRoom;
    }

    public List<BaseBullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<BaseBullet> bulletList) {
        this.bulletList = bulletList;
    }

    public List<BaseItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BaseItem> itemList) {
        this.itemList = itemList;
    }

    public List<BaseEnemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<BaseEnemy> enemyList) {
        this.enemyList = enemyList;
    }

    public List<BaseBlock> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<BaseBlock> blockList) {
        this.blockList = blockList;
    }

    public List<BaseEffect> getEffectList() {
        return effectList;
    }

    public void setEffectList(List<BaseEffect> effectList) {
        this.effectList = effectList;
    }

    public List<BaseCurse> getCurseList() {
        return curseList;
    }

    public void setCurseList(List<BaseCurse> curseList) {
        this.curseList = curseList;
    }

    public static void main(String[] args){
        Client client = new Client();
        client.launch();
    }
}
