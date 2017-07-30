package com.cokiMing.entity.role.character.major;

import com.cokiMing.client.Client;
import com.cokiMing.param.Direction;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Coki on 2017/7/30.
 */
public class CharacterIssac extends BaseMajor{

    public CharacterIssac(int x, int y, Direction direction, Client client){
        initImageMap();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.client = client;
        this.speed = 5;
    }

    @Override
    protected void initImageMap() {
        String resourcrPath = "resource/test/";
        String suffix = ".png";
        {
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
    }
}
