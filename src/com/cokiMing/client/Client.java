package com.cokiMing.client;

import com.cokiMing.entity.role.character.major.BaseMajor;
import com.cokiMing.entity.role.character.major.CharacterIssac;
import com.cokiMing.param.Direction;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Coki on 2017/7/30.
 */
public class Client extends Frame{
    //窗口宽度
    private final static int WINDOW_WIDTH = 800;
    //窗口高度
    private final static int WINDOW_HEIGHT = 600;

    BaseMajor character = new CharacterIssac(100,200, Direction.STOP,this);

    Image OffScreenImage = null;

    @Override
    public void paint(Graphics graphics){
        character.draw(graphics);
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
        this.setLocation(300,50);
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
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

    public static void main(String[] args){
        Client client = new Client();
        client.launch();
    }
}
