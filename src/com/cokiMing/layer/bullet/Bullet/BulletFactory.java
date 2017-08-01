package com.cokiMing.layer.bullet.Bullet;

import com.cokiMing.constant.Direction;
import com.cokiMing.layer.role.BaseRole;
import com.cokiMing.layer.role.character.BaseCharacter;
import com.cokiMing.layer.role.character.baby.BaseBaby;
import com.cokiMing.layer.role.character.major.BaseMajor;
import com.cokiMing.layer.role.enemy.BaseEnemy;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by wuyiming on 2017/7/31.
 */
public class BulletFactory {
    //攻击力与子弹半径系数
    private static final int BULLET_COEFFICIENT = 5;
    //子弹默认半径大小
    private static final int BULLET_DEFAULT_RADIUS = 3;
    //宝宝子弹默认半径大小
    private static final int BULLET_DEFAULT_BABY_RADIUS = 2;
    //默认子弹图片路径
    private static final String DEFAULT_BULLET_PATH = "resource/img/bullet/default/bullet.png";
    //宝宝子弹路径前缀
    private static final String PATH_BABY_PREFFIX = "resource/img/bullet/baby/";
    //玩家子弹路径前缀
    private static final String PATH_PLAYER_PREFFIX = "resource/img/bullet/player/";
    //贴图格式后缀
    private static final String PATH_SUFFIX = ".png";

    public static Bullet createBullet(BaseRole baseRole){
        Bullet bullet;
        if (baseRole instanceof BaseEnemy){
            bullet = new Bullet(baseRole) {
                @Override
                protected void initImageMap() {
                    try{
                        imageMap.put("bullet", ImageIO.read(new File(DEFAULT_BULLET_PATH)));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                protected void initBullet() {
                    bulletRadius = BULLET_DEFAULT_RADIUS;
                    direction = Direction.D;
                }
            };

            return bullet;
        }
        if (baseRole instanceof BaseCharacter){
            if (baseRole instanceof BaseBaby){
                bullet = new Bullet(baseRole) {
                    @Override
                    protected void initImageMap() {
                        String name = baseRole.getName();
                        try{
                            imageMap.put("bullet", ImageIO.read(new File(PATH_BABY_PREFFIX + name + PATH_SUFFIX)));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    protected void initBullet() {
                        bulletRadius = BULLET_DEFAULT_BABY_RADIUS;
                        direction = baseRole.getShootDirection();
                    }
                };
            }else{
                BaseMajor player = (BaseMajor) baseRole;
                bullet = new Bullet(baseRole) {
                    @Override
                    protected void initImageMap() {
                        String bulletType = player.getBulletType();
                        try{
                            imageMap.put("bullet",ImageIO.read(new File(PATH_PLAYER_PREFFIX + bulletType + PATH_SUFFIX)));
                        }catch (Exception e){
                            System.out.println(PATH_PLAYER_PREFFIX + bulletType + PATH_SUFFIX);
                            e.printStackTrace();
                        }
                    }

                    @Override
                    protected void initBullet() {
                        double damage = player.getDamage();
                        bulletRadius = (int) damage * BULLET_COEFFICIENT;
                        direction = player.getShootDirection();
                        speed = player.getShootSpeed();
                    }
                };
            }
            return bullet;
        }

        return null;
    }
}