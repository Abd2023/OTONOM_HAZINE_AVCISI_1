package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RastgeleHarita r =new RastgeleHarita();
        r.haritaolustur();

        HaritaGuncelle abdullah= new HaritaGuncelle();
        abdullah.TumIslemler();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("OTONOM HAZINE AVCISI ");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();

    }
}