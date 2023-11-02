package main;

import object.OBJ_Boots;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {


    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;


    }

    public void setObject(){
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 105 * gp.basicTitleSize  ;
        gp.obj[0].worldY = 53 * gp.basicTitleSize ;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 105 * gp.basicTitleSize ;
        gp.obj[1].worldY = 50 * gp.basicTitleSize ;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 78 * gp.basicTitleSize ;
        gp.obj[2].worldY = 27 * gp.basicTitleSize ;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 79 * gp.basicTitleSize ;
        gp.obj[3].worldY = 27 * gp.basicTitleSize ;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 80 * gp.basicTitleSize ;
        gp.obj[4].worldY = 27 * gp.basicTitleSize ;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 81 * gp.basicTitleSize ;
        gp.obj[5].worldY = 27 * gp.basicTitleSize ;

        gp.obj[6] = new OBJ_Door();
        gp.obj[6].worldX = 82 * gp.basicTitleSize ;
        gp.obj[6].worldY = 27 * gp.basicTitleSize ;

        gp.obj[7] = new OBJ_Door();
        gp.obj[7].worldX = 83 * gp.basicTitleSize ;
        gp.obj[7].worldY = 27 * gp.basicTitleSize ;

        gp.obj[8] = new OBJ_Door();
        gp.obj[8].worldX = 84 * gp.basicTitleSize ;
        gp.obj[8].worldY = 27 * gp.basicTitleSize ;

        gp.obj[9] = new OBJ_Boots();
        gp.obj[9].worldX = 84 * gp.basicTitleSize ;
        gp.obj[9].worldY = 17 * gp.basicTitleSize ;




    }

}
