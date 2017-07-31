package com.cokiMing.layer;

import java.awt.*;

/**
 * Created by wuyiming on 2017/7/31.
 */
public interface BaseLayer {
    /**
     * 轨迹定义
     */
    void move();

    /**
     * 绘制当前对象
     */
    void drawCurrent(Graphics graphics);
}
