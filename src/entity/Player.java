package entity;

import main.GamePanel;
import main.KeyHandler;
import tile.TileManeger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    public double x;
    public double y;
    double moveX ;
    double moveY ;
    public int hasKey;
    public double speed;
    public double speedBoost;
    public double maxSpeedBoost;
    private KeyHandler keyHandler;
    private GamePanel gp;
    public boolean move;
    public final double screenX;
    public final double screenY;
    private boolean directionLvP;

    public Player(GamePanel gp, KeyHandler keyHandler){
        this.keyHandler = keyHandler;
        this.gp = gp;

        screenX = gp.screemWidth/2 - (gp.basicTitleSize/2);
        screenY = gp.screemHeight/2 - (gp.basicTitleSize/2);

        solidArea = new Rectangle();
        solidArea.x  = 0;
        solidArea.y = 0;
        solidAreaDefaultX =solidArea.x;
        solidAreaDefaultY =solidArea.y;
        solidArea.height = 32;
        solidArea.width = 32;
        hasKey = 0;
        setDefaultValues();
        getPlayerImages();
    }

    public void setDefaultValues(){
        worldX = 100 * gp.basicTitleSize;
        worldY = 50 * gp.basicTitleSize;
        speed = 2;
        direction = "left";
        move = false;
        directionLast = "right";
        speedBoost = 1;
        maxSpeedBoost = 2;

    }
    public void getPlayerImages(){
        try{
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/player/lewo1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/player/prawo1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/player/lewo2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/player/prawo2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/player/gora1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/player/gora2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/player/dol1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/player/dol2.png"));
        }catch(Exception e){
            e.printStackTrace();
        }



    }


    public void update() {

//        System.out.println("X  "+worldX);
//        System.out.println("Y  "+worldY);
        gp.qT.updateOfQueueTrees();
        boolean pressed = (keyHandler.rightPressed || keyHandler.leftPressed || keyHandler.downPressed || keyHandler.upPressed) && !(keyHandler.upPressed && keyHandler.downPressed) && !(keyHandler.leftPressed && keyHandler.rightPressed);

        if(keyHandler.gPressed){
            gp.cChecker.appleTreeChecker(this);
        }
       // if(keyHandler.interactPressed)

        if (pressed) {
             moveX = 0;
             moveY = 0;

            if (keyHandler.upPressed && !gp.cChecker.canMove(this, 0, -speed * speedBoost)) {
                moveY -= speed * speedBoost;
                direction = "up";
            }else if (keyHandler.downPressed && !gp.cChecker.canMove(this, 0, speed * speedBoost)) {
                moveY += speed * speedBoost;
                direction = "down";
            }

            if (keyHandler.leftPressed && !gp.cChecker.canMove(this, -speed * speedBoost, 0)) {
                moveX -= speed * speedBoost;
                direction = "left";
            }else if (keyHandler.rightPressed && !gp.cChecker.canMove(this, speed * speedBoost, 0)) {
                moveX += speed * speedBoost;
                direction = "right";
            }

            int objIndex = gp.cChecker.checkObject(this, true, moveX, moveY);
            pickUpObject(objIndex);
                worldX += moveX;
                worldY += moveY;

            if (direction == directionLast && speedBoost < maxSpeedBoost && pressed) {
                speedBoost = 1.01 * speedBoost;
            } else if (direction == directionLast && speedBoost >= maxSpeedBoost && pressed) {
                speedBoost=maxSpeedBoost;
            } else {
                speedBoost = 1;
            }
            counterSprite();
            directionLast = direction;

        }

    }

    public void counterSprite(){
        spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum == 1){
                spriteNum = 0;
            }else{
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void pickUpObject(int i){
        if(i != 99999){


            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    break;

                case "Door":
                    if(hasKey>0){
                        gp.cChecker.fewDoors(i);
                        hasKey--;
                    }
                    System.out.println("Keys :" + hasKey);
                    break;
                case "Boots":
                    speed++;
                    gp.obj[i] = null;


                    break;
            }



        }
    }

    public void draw(Graphics g2){
        BufferedImage image = down1 ;
        switch (direction){
            case "up":
                if(spriteNum == 1) {
                    image = up2;
                }else{
                    image=up1;
                }
                break;
            case"down":
                if(spriteNum == 1) {
                    image=down1;
                }else{
                    image=down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image=left1;
                }else{
                    image=left2;
                }
                break;
            case "right":
                if( spriteNum == 1) {
                    image=right1;
                }else{
                    image=right2;
                }
                break;
        }
        g2.drawImage(image, (int)screenX, (int)screenY, gp.basicTitleSize, gp. basicTitleSize, null);

    }




}

