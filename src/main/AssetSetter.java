package main;

import object.OBJ_AltinSandigi;
import object.OBJ_Bakir;
import object.OBJ_Gumus;
import object.OBJ_Zumrut;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp)  {
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_Zumrut();
        gp.obj[0].worldX = 4 * gp.tileSize;
        gp.obj[0].worldY = 11 * gp.tileSize;

        gp.obj[1] = new OBJ_Zumrut();
        gp.obj[1].worldX = 8 * gp.tileSize;
        gp.obj[1].worldY = 17 * gp.tileSize;

        gp.obj[2] = new OBJ_Gumus();
        gp.obj[2].worldX = 10 * gp.tileSize;
        gp.obj[2].worldY = 20 * gp.tileSize;

        gp.obj[3] = new OBJ_Bakir();
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 24 * gp.tileSize;


        gp.obj[5] = new OBJ_AltinSandigi();
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;


        gp.obj[5] = new OBJ_AltinSandigi();
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 28 * gp.tileSize;





        ////////////////////////
////        kapı vermek için
//        gp.obj[2] = new OBJ_Door();
//        gp.obj[2].worldX = 25 * gp.tileSize;
//        gp.obj[2].worldY = 25 * gp.tileSize;
//
//        gp.obj[3] = new OBJ_Door();
//        gp.obj[3].worldX = 36 * gp.tileSize;
//        gp.obj[3].worldY = 24 * gp.tileSize;
//
//        gp.obj[4] = new OBJ_Door();
//        gp.obj[4].worldX = 11 * gp.tileSize;
//        gp.obj[4].worldY = 15 * gp.tileSize;
////////////////////////////////



    }

}
