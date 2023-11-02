package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;

    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 32,32);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = (int) (worldX - gp.player.worldX + gp.player.screenX);
        int screenY = (int) (worldY - gp.player.worldY + gp.player.screenY);

        if (worldX + gp.basicTitleSize> gp.player.worldX - gp.player.screenX
                && worldY - gp.basicTitleSize< gp.player.worldY + gp.player.screenY
                && worldY + gp.basicTitleSize> gp.player.worldY - gp.player.screenY
                && worldY - gp.basicTitleSize< gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, gp.basicTitleSize, gp.basicTitleSize, null);
        }
    }

}
