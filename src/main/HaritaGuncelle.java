package main;

import java.io.*;
import java.util.Random;

public class HaritaGuncelle {

    private static final int BOYUT = 50;


    public static int[][] harita; // Declare harita as a class member

    public int[][] getHarita() {
        return harita;
    }

    public HaritaGuncelle() {
        harita = new int[BOYUT][BOYUT]; // Initialize the harita array
    }


    public int[][] haritayiOku(String dosyaYolu) {
        int[][] harita = new int[BOYUT + 50][BOYUT + 50];
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

                for (int i = satir ; i < satir +2; i++) {
                    for (int j = sutun; j < sutun + 2; j++) {

                        harita[i][j] = 50;
                    }
                }

                harita[satir][sutun] = 9;

                sayac++;
            }
        }

        // Land Mountain için
        sayac = 0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 0) {

                for (int i = satir ; i < satir +3; i++) {
                    for (int j = sutun; j < sutun + 3; j++) {

                        harita[i][j] = 50;
                    }
                }

                harita[satir][sutun] = 7;

                sayac++;
            }
        }

        // snow mountain
        sayac = 0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1) {

                for (int i = satir ; i < satir +3; i++) {
                    for (int j = sutun; j < sutun + 3; j++) {

                        harita[i][j] = 50;
                    }
                }

                harita[satir][sutun] = 10;

                sayac++;
            }
        }


//        int kusunUcmayaBasladigiYerX;
//        int kusunUcmayaBasladigiYerY;
//
//        // kusun ucacagi kirmizi tilelar
//        sayac=0;
//        while (sayac < 2) {
//            int satir = rand.nextInt(BOYUT);
//            int sutun = rand.nextInt(BOYUT);
//
//            if (harita[satir][sutun] == 0
//                    &&harita[satir+1][sutun] == 0
//                    &&harita[satir+2][sutun] == 0
//                    &&harita[satir+3][sutun] == 0
//                    &&harita[satir+4][sutun] == 0
//                    &&harita[satir+5][sutun] == 0
//                    &&harita[satir+6][sutun] == 0
//            ) {
//                harita[satir][sutun] = 13;
//                harita[satir+1][sutun] = 13;
//                harita[satir+2][sutun] = 13;
//                harita[satir+3][sutun] = 13;
//                harita[satir+4][sutun] = 13;
//                harita[satir+5][sutun] = 13;
//                harita[satir+6][sutun] = 13;
//
//
//                sayac++;
//                kusunUcmayaBasladigiYerX=satir+3;
//                kusunUcmayaBasladigiYerY=sutun;
//
//            }
//        }




        //mehmet
        // duvarlar deneme
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);

            if (harita[satir][sutun] == 0
                    &&harita[satir][sutun+1] == 0
                    &&harita[satir][sutun+2] == 0
                    &&harita[satir][sutun+3] == 0
                    &&harita[satir][sutun+4] == 0
                    &&harita[satir][sutun+5] == 0
                    &&harita[satir][sutun+6] == 0
                    &&harita[satir][sutun+7] == 0
                    &&harita[satir][sutun+8] == 0
                    &&harita[satir][sutun+9] == 0 ) {
                harita[satir][sutun+1] = 8;
                harita[satir][sutun+2] = 8;
                harita[satir][sutun+3] = 8;
                harita[satir][sutun+4] = 8;
                harita[satir][sutun+5] = 8;
                harita[satir][sutun+6] = 8;
                harita[satir][sutun+7] = 8;
                harita[satir][sutun+8] = 8;
                harita[satir][sutun+9] = 8;
                harita[satir][sutun] = 8;

                sayac++;
            }
        }


        // kıs taraf duvarlar
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1
                    &&harita[satir][sutun+1] == 1
                    &&harita[satir][sutun+2] == 1
                    &&harita[satir][sutun+3] == 1
                    &&harita[satir][sutun+4] == 1
                    &&harita[satir][sutun+5] == 1
                    &&harita[satir][sutun+6] == 1
                    &&harita[satir][sutun+7] == 1
                    &&harita[satir][sutun+8] == 1
                    &&harita[satir][sutun+9] == 1 ) {
                harita[satir][sutun+1] = 12;
                harita[satir][sutun+2] = 12;
                harita[satir][sutun+3] = 12;
                harita[satir][sutun+4] = 12;
                harita[satir][sutun+5] = 12;
                harita[satir][sutun+6] = 12;
                harita[satir][sutun+7] = 12;
                harita[satir][sutun+8] = 12;
                harita[satir][sutun+9] = 12;
                harita[satir][sutun] = 12;

                sayac++;
            }
        }


        // Land Tree için
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 0
            &&harita[satir + 1][sutun] == 0
            &&harita[satir][sutun +1] == 0
            &&harita[satir + 1][sutun + 1] == 0) {
                harita[satir][sutun] = 3;
                harita[satir + 1][sutun] = 50;
                harita[satir][sutun + 1] = 50;
                harita[satir + 1][sutun + 1] = 50;
                sayac++;
            }
        }

        sayac = 0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1) {

                for (int i = satir ; i < satir +2; i++) {
                    for (int j = sutun; j < sutun + 2; j++) {

                        harita[i][j] = 50;
                    }
                }

                harita[satir][sutun] = 11;

                sayac++;
            }
        }


//snow tree için
        sayac=0;
        while (sayac < 5) {
            int satir = rand.nextInt(BOYUT);
            int sutun = rand.nextInt(BOYUT);
            if (harita[satir][sutun] == 1
                    &&harita[satir + 1][sutun] == 1
                    &&harita[satir][sutun +1] == 1
                    &&harita[satir + 1][sutun + 1] == 1) {
                harita[satir][sutun] = 2;
                harita[satir + 1][sutun] = 50;
                harita[satir][sutun + 1] = 50;
                harita[satir + 1][sutun + 1] = 50;
                sayac++;
            }
        }


//        // duar için
//        sayac=0;
//        while (sayac < 5) {
//            int satir = rand.nextInt(BOYUT);
//            int sutun = rand.nextInt(BOYUT);
//            if (harita[satir][sutun] == 0) {
//                harita[satir][sutun] = 8;
//
//                harita[satir][sutun + 1] = 50;
//                harita[satir][sutun + 2] = 50;
//                harita[satir][sutun + 3] = 50;
//                harita[satir][sutun + 5] = 50;
//                harita[satir][sutun + 6] = 50;
//                harita[satir][sutun + 7] = 50;
//                harita[satir][sutun + 8] = 50;
//                harita[satir][sutun + 9] = 50;
//
//                sayac++;
//            }
//        }


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


            for (int i = 0; i < BOYUT; i++) {
                for (int j = 0; j < BOYUT; j++) {
                    harita[i][j] =  matris[i][j];
                }

            }


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
        System.out.println("----------------Harita Guncelle için matris yazdır-----------------------");
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