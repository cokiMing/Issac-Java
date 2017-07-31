package com.cokiMing.layer.role.character.major;

import com.cokiMing.client.Client;
import com.cokiMing.entity.Character;
import com.cokiMing.param.Direction;
import com.cokiMing.util.CharacterUtil;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Coki on 2017/7/30.
 */
public class MajorFactory {

    public static final String CHARACTER_ISSAC = "issac";
    public static final String CHARACTER_AZAL = "azal";
    public static final String CHARACTER_KEEPER = "keeper";
    public static final String CHARACTER_JODA = "joda";
    public static final String CHARACTER_GAIN = "gain";
    public static final String CHARACTER_LILITH = "lilith";
    public static final String CHARACTER_LOST = "lost";

    private static final int INIT_X = 100;
    private static final int INIT_Y = 50;
    private static final Direction INIT_DIRECTION = Direction.D;

    private static final Set<String> characterList = new HashSet<String>(){
        {
            add(CHARACTER_ISSAC);
            add(CHARACTER_AZAL);
            add(CHARACTER_KEEPER);
            add(CHARACTER_JODA);
            add(CHARACTER_GAIN);
            add(CHARACTER_LILITH);
            add(CHARACTER_LOST);
        }
    };

    public static BaseMajor createCharacter(String characterName, Client client){
        if (!characterList.contains(characterName)){
            throw new RuntimeException("No such character");
        }

        String resourcrPath = "resource/img/character/" + characterName + "/";
        String suffix = ".png";


        BaseMajor baseMajor = new BaseMajor() {
            @Override
            protected void initImageMap() {
                try{
                    imageMap.put("headL", ImageIO.read(new File(resourcrPath+"headL"+suffix)));
                    imageMap.put("headLU",ImageIO.read(new File(resourcrPath+"headLU"+suffix)));
                    imageMap.put("headU",ImageIO.read(new File(resourcrPath+"headU"+suffix)));
                    imageMap.put("headRU",ImageIO.read(new File(resourcrPath+"headRU"+suffix)));
                    imageMap.put("headR",ImageIO.read(new File(resourcrPath+"headR"+suffix)));
                    imageMap.put("headRD",ImageIO.read(new File(resourcrPath+"headRD"+suffix)));
                    imageMap.put("headD",ImageIO.read(new File(resourcrPath+"headD"+suffix)));
                    imageMap.put("headLD",ImageIO.read(new File(resourcrPath+"headLD"+suffix)));
                    imageMap.put("headSTOP",ImageIO.read(new File(resourcrPath+"headD"+suffix)));
                    imageMap.put("bodyL", ImageIO.read(new File(resourcrPath+"bodyL"+suffix)));
                    imageMap.put("bodyLU",ImageIO.read(new File(resourcrPath+"bodyLU"+suffix)));
                    imageMap.put("bodyU",ImageIO.read(new File(resourcrPath+"bodyU"+suffix)));
                    imageMap.put("bodyRU",ImageIO.read(new File(resourcrPath+"bodyRU"+suffix)));
                    imageMap.put("bodyR",ImageIO.read(new File(resourcrPath+"bodyR"+suffix)));
                    imageMap.put("bodyRD",ImageIO.read(new File(resourcrPath+"bodyRD"+suffix)));
                    imageMap.put("bodyD",ImageIO.read(new File(resourcrPath+"bodyD"+suffix)));
                    imageMap.put("bodyLD",ImageIO.read(new File(resourcrPath+"bodyLD"+suffix)));
                    imageMap.put("bodySTOP",ImageIO.read(new File(resourcrPath+"bodySTOP"+suffix)));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Character character = CharacterUtil.getCharacter(characterName);
        baseMajor.setX(INIT_X);
        baseMajor.setX(INIT_Y);
        baseMajor.setDamage(character.getDamage());
        baseMajor.setRange(character.getRange());
        baseMajor.setShootRate(character.getShootRate());
        baseMajor.setShootSpeed(character.getShootSpeed());
        baseMajor.setLuck(character.getLuck());
        baseMajor.setDirection(INIT_DIRECTION);
        baseMajor.setClient(client);

        return baseMajor;
    }

    public static void main(String args[]){

    }
}
