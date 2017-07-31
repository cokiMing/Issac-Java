package com.cokiMing.util;

import com.cokiMing.constant.CharacterName;
import com.cokiMing.entity.Character;
import com.cokiMing.entity.Item;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by wuyiming on 2017/7/31.
 */
public class CharacterUtil {

    private static final String PATH_CHARACTER_PREFIX = "resource/conf/character/";

    private static final String PATH_CHARACTER_SUFFIX = ".xml";

    public static Character getCharacter(String characterName){
        Document document = XmlUtil.getDocument(PATH_CHARACTER_PREFIX + characterName + PATH_CHARACTER_SUFFIX);
        Element rootElement = document.getRootElement();
        Element element = rootElement.element(characterName);

        String name = element.attributeValue("name");
        double damage = Double.parseDouble(element.attributeValue("damage"));
        double range = Double.parseDouble(element.attributeValue("range"));
        int shootRate = Integer.parseInt(element.attributeValue("shootRate"));
        double shootSpeed = Double.parseDouble(element.attributeValue("shootSpeed"));
        int luck = Integer.parseInt(element.attributeValue("luck"));
        String[] lifeList = element.attributeValue("lifeList").split(",");
        Item activeItem = ItemUtil.getItem(element.attributeValue("itemId"));
        List<Item> itemList = ItemUtil.getItemList(element.attributeValue("passiveItemList").split(","));
        Item primaryItem = ItemUtil.getItem(element.attributeValue("primaryItem"));
        Item baseOrnament = ItemUtil.getItem(element.attributeValue("baseOrnament"));
        int coinNum = Integer.parseInt(element.attributeValue("coinNum"));
        int keyNum = Integer.parseInt(element.attributeValue("keyNum"));
        int bombNum = Integer.parseInt(element.attributeValue("bombNum"));
        int lives = Integer.parseInt(element.attributeValue("lives"));
        boolean isFlyable = Boolean.parseBoolean(element.attributeValue("isFlyable"));

        Character character = new Character();
        character.setName(name);
        character.setDamage(damage);
        character.setRange(range);
        character.setShootRate(shootRate);
        character.setShootSpeed(shootSpeed);
        character.setLuck(luck);
        character.setActiveItem(activeItem);
        character.setPassiveItemList(itemList);
        character.setPrimaryItem(primaryItem);
        character.setBaseOrnament(baseOrnament);
        character.setCoinNum(coinNum);
        character.setKeyNum(keyNum);
        character.setBombNum(bombNum);
        character.setLives(lives);
        character.setFlyable(isFlyable);

        return character;
    }

    public static void main(String[] args){
        Character character = getCharacter(CharacterName.ISSAC);
        System.out.println(character);
    }
}
