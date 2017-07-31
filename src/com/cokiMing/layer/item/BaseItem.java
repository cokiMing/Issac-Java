package com.cokiMing.layer.item;

import com.cokiMing.layer.BaseLayer;
import com.cokiMing.layer.role.BaseRole;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Coki on 2017/7/30.
 */
public abstract class BaseItem implements BaseLayer {
    protected String id;
    protected String name;
    protected String description;
    protected Map<String,Image> imageMap = new HashMap<>();
    protected BaseRole baseRole;

    public BaseItem(){
    }

    public BaseItem(BaseRole baseRole){
        this.baseRole = baseRole;
    }

    /**
     * 绘制对象
     */
    public void draw(Graphics graphics){
        drawCurrent(graphics);
        move();
    }

    /**
     * 道具拾取时对角色的影响
     */
    public abstract void addEffect();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
