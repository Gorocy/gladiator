package main;

import entity.Entity;
import entity.Player;
//import tile.QueueTrees;
import tile.*;

public class CollisionChecker  {
    GamePanel gp;
    int entityLeftWorldX;
    int entityRightWorldX;
    int entityTopWorldY;
    int entityBottomWorldY;

    int entityLeftCol;
    int entityRightCol;
    int entityTopRow;
    int entityBottomRow;
    int tileNum, tileNum2;

    int entityWorldY;
    int entityWorldX;
    int entityCol;
    int entityRow;
    public QueueTrees list;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
        list = new QueueTrees(gp);
    }




    public boolean canMove(Entity entity, double moveX, double moveY) {
         entityWorldX = (int) (entity.worldX + gp.basicTitleSize / 2 + moveX);
         entityWorldY = (int) (entity.worldY + gp.basicTitleSize / 2 + moveY);
         entityCol = entityWorldX / gp.basicTitleSize;
         entityRow = entityWorldY / gp.basicTitleSize;

         tileNum = gp.tileM.mapTileNum[entityCol][entityRow];
        return gp.tileM.tile[tileNum].collision;
    }

    public void appleTreeChecker(Entity entity){
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                entityWorldX =  (entity.worldX + gp.basicTitleSize / 2  );
                entityWorldY =  (entity.worldY + gp.basicTitleSize / 2  );
                entityCol =-1+i +entityWorldX / gp.basicTitleSize;
                entityRow =-1+j +entityWorldY / gp.basicTitleSize;


                if(gp.tileM.mapTileNum[entityCol][entityRow] == 8){
                    gp.tileM.mapTileNum[entityCol][entityRow] = 9;

                    gp.qT.enqueue(entityCol, entityRow);

                }
            }
        }
    }
    public void Interact(Entity entity){
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                entityWorldX =  (entity.worldX + gp.basicTitleSize / 2  );
                entityWorldY =  (entity.worldY + gp.basicTitleSize / 2  );
                entityCol =-1+i +entityWorldX / gp.basicTitleSize;
                entityRow =-1+j +entityWorldY / gp.basicTitleSize;


                if(gp.tileM.mapTileNum[entityCol][entityRow] == 4){


                }
            }
        }
    }
//    public void fewDoors(int i){
//        int x= gp.obj[i].worldX;
//        int y= gp.obj[i].worldY;
//        gp.obj[i] = null;
//        for(int j = 0; j < gp.obj.length; j++){
//            if(null != gp.obj[j]){
//                if((x + gp.basicTitleSize) == gp.obj[j].worldX){
//
//                    fewDoors(j);
//                    System.out.println("fgg");
//                    break;
//                }
//                if((x - gp.basicTitleSize) == gp.obj[j].worldX){
//
//                    fewDoors(j);
//                    System.out.println("fgg");
//                    break;
//                }
//                if((y + gp.basicTitleSize) == gp.obj[j].worldY){
//
//                    fewDoors(j);
//                    System.out.println("fgg");
//                    break;
//                }
//                if((y - gp.basicTitleSize) == gp.obj[j].worldY){
//
//                    fewDoors(j);
//                    System.out.println("fgg");
//                    break;
//                }
//
//            }
//
//        }
//    }
public void fewDoors(int i) {
    int x = gp.obj[i].worldX;
    int y = gp.obj[i].worldY;
    gp.obj[i] = null;

    for (int j = 0; j < gp.obj.length; j++) {
        if (gp.obj[j] != null) {
            if (isAdjacent(x, y, gp.obj[j].worldX, gp.obj[j].worldY)  && gp.obj[j].name == "Door") {
                fewDoors(j);
                System.out.println("fgg");

            }
        }
    }
}
    public boolean isAdjacent(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) == gp.basicTitleSize || Math.abs(y1 - y2) == gp.basicTitleSize;
    }
    public int checkObject(Entity entity, boolean player, double moveX, double moveY){
        int index = 99999;

        for(int i = 0; i<gp.obj.length; i++){
            if(null != gp.obj[i]){

                entity.solidArea.x = entity.worldX + entity.solidArea.x + (int)moveX ;
                entity.solidArea.y = entity.worldY + entity.solidArea.y + (int)moveY ;

                gp.obj[i].solidArea.x =  gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y =  gp.obj[i].worldY + gp.obj[i].solidArea.y;

                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    index = i;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }

        }


        return index;
    }
}


//public void checkTileUp(Entity entity) {
//    int entityLeftWorldX = entity.worldX + gp.basicTitleSize/2;
//    int entityTopWorldY = entity.worldY + entity.solidArea.y - (int)(entity.speed * entity.speedBoost);
//    int entityLeftCol = entityLeftWorldX / gp.basicTitleSize;
//    int entityTopRow = entityTopWorldY / gp.basicTitleSize;
//
//    int tileNum = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//    entity.collisionOn = gp.tileM.tile[tileNum].collision;
//}
//
//    public void checkTileDown(Entity entity) {
//        int entityLeftWorldX = entity.worldX + gp.basicTitleSize/2;
//        int entityBottomWorldY = entity.worldY + entity.solidArea.height + (int)(entity.speed * entity.speedBoost);
//        int entityLeftCol = entityLeftWorldX / gp.basicTitleSize;
//        int entityBottomRow = entityBottomWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileLeft(Entity entity) {
//        int entityLeftWorldX = entity.worldX + entity.solidArea.x - (int)(entity.speed * entity.speedBoost);
//        int entityTopWorldY = entity.worldY +  gp.basicTitleSize/2;
//        int entityLeftCol = entityLeftWorldX / gp.basicTitleSize;
//        int entityTopRow = entityTopWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileRight(Entity entity) {
//        int entityRightWorldX = entity.worldX + entity.solidArea.width + (int)(entity.speed * entity.speedBoost);
//        int entityTopWorldY = entity.worldY +  gp.basicTitleSize/2;
//        int entityRightCol = entityRightWorldX / gp.basicTitleSize;
//        int entityTopRow = entityTopWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileUpLeft(Entity entity) {
//        int entityLeftWorldX = entity.worldX + entity.solidArea.x - (int)(entity.speed * entity.speedBoost);
//        int entityTopWorldY = entity.worldY + entity.solidArea.y - (int)(entity.speed * entity.speedBoost);
//        int entityLeftCol = entityLeftWorldX / gp.basicTitleSize;
//        int entityTopRow = entityTopWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileUpRight(Entity entity) {
//        int entityRightWorldX = entity.worldX + entity.solidArea.width + (int)(entity.speed * entity.speedBoost);
//        int entityTopWorldY = entity.worldY + entity.solidArea.y - (int)(entity.speed * entity.speedBoost);
//        int entityRightCol = entityRightWorldX / gp.basicTitleSize;
//        int entityTopRow = entityTopWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileDownLeft(Entity entity) {
//        int entityLeftWorldX = entity.worldX + entity.solidArea.x - (int)(entity.speed * entity.speedBoost);
//        int entityBottomWorldY = entity.worldY + entity.solidArea.height + (int)(entity.speed * entity.speedBoost);
//        int entityLeftCol = entityLeftWorldX / gp.basicTitleSize;
//        int entityBottomRow = entityBottomWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }
//
//    public void checkTileDownRight(Entity entity) {
//        int entityRightWorldX = entity.worldX + entity.solidArea.width + (int)(entity.speed * entity.speedBoost);
//        int entityBottomWorldY = entity.worldY + entity.solidArea.height + (int)(entity.speed * entity.speedBoost);
//        int entityRightCol = entityRightWorldX / gp.basicTitleSize;
//        int entityBottomRow = entityBottomWorldY / gp.basicTitleSize;
//
//        int tileNum = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//        entity.collisionOn = gp.tileM.tile[tileNum].collision;
//    }