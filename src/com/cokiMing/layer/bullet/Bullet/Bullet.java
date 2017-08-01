package com.cokiMing.layer.bullet.Bullet;

import com.cokiMing.layer.bullet.BaseBullet;
import com.cokiMing.layer.role.BaseRole;

import java.awt.*;

/**
 * Created by wuyiming on 2017/7/31.
 */
public abstract class Bullet extends BaseBullet {
    protected int bulletRadius;

    public Bullet(BaseRole baseRole){
        super(baseRole);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(imageMap.get("bullet"),x,y,2 * bulletRadius, 2 * bulletRadius,null);
        move();
    }

    private void move(){
        switch (direction){
            case L:
                x -= speed;
                break;
            case LU:
                x -= Math.sqrt(speed);
                y -= Math.sqrt(speed);
                break;
            case U:
                y -= speed;
                break;
            case RU:
                x += Math.sqrt(speed);
                y -= Math.sqrt(speed);
                break;
            case R:
                x += speed;
                break;
            case RD:
                x += Math.sqrt(speed);
                y += Math.sqrt(speed);
                break;
            case D:
                y += speed;
                break;
            case LD:
                x -= Math.sqrt(speed);
                y += Math.sqrt(speed);
                break;
        }
    }
}
