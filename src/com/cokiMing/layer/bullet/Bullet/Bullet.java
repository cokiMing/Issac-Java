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
                x -= xSpeed;
                break;
            case LU:
                x -= xSpeed;
                y -= ySpeed;
                break;
            case U:
                y -= ySpeed;
                break;
            case RU:
                x += xSpeed;
                y -= ySpeed;
                break;
            case R:
                x += xSpeed;
                break;
            case RD:
                x += xSpeed;
                y += ySpeed;
                break;
            case D:
                y += ySpeed;
                break;
            case LD:
                x -= xSpeed;
                y += ySpeed;
                break;
        }
    }
}
