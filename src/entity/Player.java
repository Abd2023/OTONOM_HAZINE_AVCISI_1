package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

//    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    int standCounter = 0;

    int hasGumus = 0;
    int hasAltin = 0;
    int hasZumrut = 0;
    int hasBakir = 0;


    public Player(GamePanel gp , KeyHandler keyH){

        super(gp);
        this.keyH = keyH;
        /*
         screenX =gp.screenWidth/2 - (gp.tileSize/2);
        screenY=gp.screenHight/2-(gp.tileSize/2);
         */
        screenX =gp.screenWidth/2 ;
        screenY=gp.screenHight/2;


        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 32;
        solidArea.height = 32;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        worldX = gp.tileSize *23;
        worldY = gp.tileSize * 21;

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed == true){
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";

            }

            collisonOn = false;
            gp.cChecker.checkTile(this);


            int objIndex =  gp.cChecker.checkObject(this, true);

            pickupObject(objIndex);


//            //Check npc collision
//            int npcIndex=gp.cChecker.checkEntity(this, gp.npc);
//            interactNPC(npcIndex);

            if(collisonOn == false){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }


    }


    public void pickupObject(int i){

        if(i != 999 && gp.obj[i] != null ){



            String objectName = gp.obj[i].name;

            int treasureX = gp.obj[i].worldX;
            int treasureY = gp.obj[i].worldY;

            System.out.println( objectName + "hazineyi bu koordinatta (" + treasureX +", " + treasureY+") buldum");


            //////////

            switch (objectName){
                case "Gumus" :
                    hasGumus++;
                    gp.obj[i] = null;
                    System.out.println(hasGumus + " tane Gumus toplandi");
                    break;
                case "Zumrut":
                    hasZumrut++;
                    gp.obj[i] = null;
                    System.out.println(hasZumrut + " tane Zumrut toplandi");
                    break;
                case "Bakir":
                    hasBakir++;
                    gp.obj[i] = null;
                    System.out.println(hasBakir + " tane Bakır toplandi");
                    break;
                case "gold":
                    hasAltin++;
                    gp.obj[i] = null;
                    System.out.println( hasAltin + " tane Altin Sandigi toplandi");
                    break;
//                default:
//                    hasAltin++;
//                    gp.obj[i] = null;
//                    System.out.println( hasAltin + " tane Altin Sandigi toplandi");
//                    break;
            }

            ////////////

        }

    }


    public void interactNPC(int i)
    {
        if(i!=999)
        {
            System.out.println("you are hitting an npc");
        }
    }

    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//
//        g2.fillRect(x, y , gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down" :
                if(spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left" :
                if(spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right" :
                if(spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
            }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
