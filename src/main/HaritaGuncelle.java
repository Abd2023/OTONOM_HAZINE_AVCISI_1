package main;

import java.io.*;
import java.util.Random;

public class HaritaGuncelle {

    private static final int BOYUT = 50;

    public int[][] haritayiOku(String dosyaYolu) {
        int[][] harita = new int[BOYUT][BOYUT];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu));
            String satir;
            int satirIndex = 0;
            while ((satir = reader.readLine()) != null && satirIndex < BOYUT) {
                String[] satirDizi = satir.split("\\s+"); // Boşluk karakterlerine göre ayır
                for (int i = 0; i < BOYUT && i < satirDizi.length; i++) {
                    harita[satirIndex][i] = Integer.parseInt(satirDizi[i].trim()); // String'i int'e çevirirken boşlukları kaldır
                }
                satirIndex++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return harita;
    }

    public void rastgeleSifirlariDokuzaYap(int[][] harita) {
        Random rand = new Random();
        int sayac = 0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 0) {
                harita[satir][sutun] = 9;
                sayac++;
            }
        }
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 0) {
                harita[satir][sutun] = 7;
                sayac++;
            }
        }
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 0) {
                harita[satir][sutun] = 3;
                sayac++;
            }
        }
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1) {
                harita[satir][sutun] = 10;
                sayac++;
            }
        }
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1) {
                harita[satir][sutun] = 11;
                sayac++;
            }
        }
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1) {
                harita[satir][sutun] = 2;
                sayac++;
            }
        }

    }

    public void matrisiDosyayaYaz(int[][] matris, String dosyaYolu) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu));
            for (int i = 0; i < BOYUT; i++) {
                for (int j = 0; j < BOYUT; j++) {
                    writer.write(matris[i][j] + " ");
                }
                writer.newLine();
            }
            writer.close();
            System.out.println("Matris başarıyla dosyaya yazıldı: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TumIslemler() {
        String dosyaYolu = "C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\res1\\maps\\harita.txt";
        HaritaGuncelle haritaGuncelle = new HaritaGuncelle();
        int[][] harita = haritaGuncelle.haritayiOku(dosyaYolu);

        // Rastgele seçilen 5 adet 0'ı 9'a çevir
        haritaGuncelle.rastgeleSifirlariDokuzaYap(harita);

        // Matrisi ekrana yazdırma (sadece bir örnek)
        for (int i = 0; i < BOYUT; i++) {
            for (int j = 0; j < BOYUT; j++) {
                System.out.print(harita[i][j] + " ");
            }
            System.out.println();
        }
        String dosyaYolu2="C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\res1\\maps\\yeniMatris.txt";

        haritaGuncelle.matrisiDosyayaYaz(harita, dosyaYolu2);
    }
}