package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_birdland extends Entity {

    private int moveCounter; // Hareket sayacı
    private final int moveDistance = 3; // Hareket mesafesi

    public NPC_birdland(GamePanel gp) {
        super(gp);
        direction = "down"; // Başlangıç yönü aşağıya doğru
        speed = 1;
        moveCounter = 0; // Hareket sayacını sıfırla

        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/beeSnowAndLand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 120) {
            if (direction.equals("down")) {
                // Aşağıya doğru hareket ediyor
                y += speed;
                moveCounter += speed;
                if (moveCounter >= moveDistance) {
                    // Belirli mesafe aşağı indikten sonra yönü yukarıya çevir
                    direction = "up";
                    moveCounter = 0; // Hareket sayacını sıfırla
                }
            } else if (direction.equals("up")) {
                // Yukarıya doğru hareket ediyor
                y -= speed;
                moveCounter += speed;
                if (moveCounter >= moveDistance) {
                    // Belirli mesafe yukarı çıktıktan sonra yönü aşağıya çevir
                    direction = "down";
                    moveCounter = 0; // Hareket sayacını sıfırla
                }
            }
            actionLockCounter = 0;
        }
    }
}