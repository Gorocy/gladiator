package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX,worldY;
    public double speed;
    public double speedBoost;
    public double maxSpeedBoost;
    public BufferedImage left1, right2, left2, right1, up1, up2, down1, down2;
    public String direction;
    public String directionLast;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;




}
