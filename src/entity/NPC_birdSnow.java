package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_birdSnow extends Entity {

    private int moveCounter; // Hareket sayacı
    private final int moveDistance = 1; // Hareket mesafesi

    public NPC_birdSnow(GamePanel gp) {
        super(gp);
        direction = "down"; // Başlangıç yönü aşağıya doğru
        speed = 1;
        moveCounter = 0; // Hareket sayacını sıfırla

        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/birdSnow.png"));
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