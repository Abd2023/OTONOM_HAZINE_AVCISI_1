package main;

import entity.Entity;
import entity.Player;

import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int originalTileSize = 16;
    public final int scale = 2;

    public final int tileSize = originalTileSize * scale ;
    public final int maxScreenCol = 50 ;
    public final int maxScreenRow = 23 ;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHight = tileSize * maxScreenRow;

    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;





    int FPS  = 60;

    public TileManager tileM = new TileManager(this);

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);

    HaritaGuncelle haritaGuncelle = new HaritaGuncelle();
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[20];

    public Entity npc[] = new Entity[20];





    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){

        aSetter.setNPC();
        aSetter.setObject();

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null){
//
//            update();
//
//            repaint();
//
//
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if (remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if(delta > 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
//                System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer = 0;
            }


        }
    }

    public void update()
    {
        player.update();
        //npc
        for(int i=0;i< npc.length;i++)
        {
            if(npc[i]!=null){
                npc[i].update();
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //tile
        tileM.draw(g2);


        //object
        for (int i = 0; i < obj.length; i++) {

            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }


        // NPC bird
        for (int i=0;i< npc.length;i++)
        {
            if(npc[i]!=null)
            {
                npc[i].draw(g2);
            }
        }


        //player
        player.draw(g2);

        g2.dispose();
    }

}
