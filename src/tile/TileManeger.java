package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManeger {
    GamePanel gp;
    public Tile[] tile;
    private Timer timers;

    public int[][] mapTileNum;
    //public static int[][] sandTypes;

    public TileManeger(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[17];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/map/village.txt");
    }
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/grass.png")));



            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/stone2.png")));
            tile[1].collision= true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/stone.png")));


//            tile[3] = new Tile();
//            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/tree.png")));
//            tile[3].collision= true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/door.png")));
            tile[4].collision= true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/tile.png")));
            tile[5].collision= true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/wood.png")));
            tile[6].collision= true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/window.png")));
            tile[3].collision= true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/water.png")));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/treeWapple.png")));
            tile[8].collision= true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/tree.png")));
            tile[9].collision= true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/lava.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/sand2.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/sand1.png")));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/sand2.png")));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/sand3.png")));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/sand4.png")));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tiles/sand5.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;

            while (row < gp.maxWorldRow) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                String[] numbers = line.split(" ");
                for (int col = 0; col < gp.maxWorldCol && col < numbers.length; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int worldRow = 0; worldRow < gp.maxWorldRow; worldRow++) {
            for (int worldCol = 0; worldCol < gp.maxWorldCol; worldCol++) {
                
                int tileNum = mapTileNum[worldCol][worldRow];
                if(tileNum == 9 || tileNum == 8){
                timers = new Timer(tileNum);
                }
                int worldX = worldCol * gp.basicTitleSize;
                int worldY = worldRow * gp.basicTitleSize;
                int screenX = (int)(worldX - gp.player.worldX + gp.player.screenX);
                int screenY = (int)(worldY - gp.player.worldY + gp.player.screenY);

                if (tileNum >= 0 && tileNum <= 17
                        && worldX + gp.basicTitleSize> gp.player.worldX - gp.player.screenX
                        && worldY - gp.basicTitleSize< gp.player.worldY + gp.player.screenY
                        && worldY + gp.basicTitleSize> gp.player.worldY - gp.player.screenY
                        && worldY - gp.basicTitleSize< gp.player.worldY + gp.player.screenY) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.basicTitleSize, gp.basicTitleSize, null);
                }
//                if(worldX> gp.player.worldX - gp.player.screenX && worldY< gp.player.worldY + gp.player.screenY && worldY> gp.player.worldY - gp.player.screenY && worldY< gp.player.worldY + gp.player.screenY){
//
//                }

            }
        }
    }

}

