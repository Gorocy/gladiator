package main;

import object.OBJ_Apple;
import object.OBJ_Key;
import object.OBJ_Money;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font arial_32;
    BufferedImage keyImage;
    BufferedImage appleImage;
    BufferedImage moneyImage;
//    BufferedImage keyImage;
//    BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";
    public UI(GamePanel gp){
        this.gp = gp;
        arial_32 = new Font("Arial", Font.PLAIN, gp.basicTitleSize*2);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
        OBJ_Apple apple = new OBJ_Apple();
        appleImage = apple.image;
        OBJ_Money money = new OBJ_Money();
        moneyImage = money.image;
//        OBJ_Money money = new OBJ_Money();
//        moneyImage = money.image;

    }

    public void showMessage(String text){
        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2){

        g2.setFont(arial_32);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.basicTitleSize/2, gp.basicTitleSize/2, gp.basicTitleSize*2, gp.basicTitleSize*2, null );
        g2.drawString(" "+ gp.player.hasKey, 84, 72);
        g2.drawImage(appleImage, gp.basicTitleSize/2, gp.basicTitleSize/2+ gp.basicTitleSize*2, gp.basicTitleSize*2, gp.basicTitleSize*2, null );
        g2.drawString(" "+ gp.player.hasKey, 84, 72+ gp.basicTitleSize*2);
        g2.drawImage(moneyImage, gp.basicTitleSize/2, gp.basicTitleSize/2+ gp.basicTitleSize*4, gp.basicTitleSize*2, gp.basicTitleSize*2, null );
        g2.drawString(" "+ gp.player.hasKey, 84, 72+ gp.basicTitleSize*4);
        g2.drawImage(appleImage, gp.basicTitleSize/2, gp.basicTitleSize/2+ gp.basicTitleSize*6, gp.basicTitleSize*2, gp.basicTitleSize*2, null );
        g2.drawString(" "+ gp.player.hasKey, 84, 72+ gp.basicTitleSize*6);
    }


}
