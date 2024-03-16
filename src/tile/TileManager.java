package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp  = gp;

        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/yeniMatris.txt");
    }

    public void getTileImage(){

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/greenLand.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowLand.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowTree3.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/landTree1.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/beeSnowAndLand.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/birdLand.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/birdSnow.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/landMountain.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/landWall.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rockLand.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowMountain.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowRock.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowWall1.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/redtile.png"));
            tile[13].collision = true;

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch (Exception e){

        }


    }
    public void draw(Graphics2D g2){

        //yeşilik için
//        for (int i = 0; i <= gp.maxScreenRow ; i++) {
//            for (int j = 0; j <= gp.maxScreenCol /2; j++) {
//                g2.drawImage(tile[0].image, i * gp.originalTileSize * gp.scale, j * gp.originalTileSize * gp.scale, gp.tileSize, gp.tileSize, null);
//            }
//        }
//
//        //kar için
//        for (int i = 15; i < gp.maxScreenCol ; i++) {
//            for (int j = 0; j < gp.maxScreenRow; j++) {
//                g2.drawImage(tile[1].image, i * gp.originalTileSize * gp.scale, j* gp.originalTileSize * gp.scale, gp.tileSize, gp.tileSize, null);
//            }
//        }

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        int worldCol = 0;
        int worldRow = 0;



        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

//            int worldX = col * gp.tileSize;
//            int worldY = row * gp.tileSize;


            int worldX= worldCol * gp.tileSize;
            int worldY= worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX +gp.player.screenX;
            int  screenY=worldY - gp.player.worldY+gp.player.screenY;

            if(worldX + gp.tileSize>gp.player.worldX -gp.player.screenX &&
                    worldX-gp.tileSize<gp.player.worldX+gp.player.screenX &&
                    worldY+gp.tileSize>gp.player.worldY-gp.player.screenY &&
                    worldY-gp.tileSize<gp.player.worldY + gp.player.screenY)
            {

                //ağaç için
                if(tileNum == 3) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);
//                    worldCol += 2;
//                    worldRow += 2;

                }

                // Land Mountain
//                else if(tileNum == 7)
//                {
//                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize * 10, gp.tileSize * 10, null);
////                    worldCol += 2;
////                    worldRow += 2;
//
//                }
                else if(tileNum != 50){
                    g2.drawImage( tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }

            }



            worldCol++;
            col++;
            x += gp.tileSize;

            if(worldCol == gp.maxScreenCol){

                worldCol = 0;
                worldRow++;

                col = 0;
                x=0;
                row++;
                y += gp.tileSize;
            }
        }

    }

}
