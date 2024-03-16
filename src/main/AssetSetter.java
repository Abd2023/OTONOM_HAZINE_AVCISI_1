package main;

import object.*;

import entity.NPC_birdland;
import entity.NPC_birdSnow;
import entity.NPC_SnowAndLand;

import java.io.*;
import java.util.Random;


public class AssetSetter {

    private static final int BOYUT = 50;

    String dosyaYolu = "C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\yeniMatris.txt";
    HaritaGuncelle haritaGuncelle = new HaritaGuncelle();
    int[][] harita = haritaGuncelle.haritayiOku(dosyaYolu);


    GamePanel gp;
    public AssetSetter()
    {

    }

    public AssetSetter(GamePanel gp)  {this.gp = gp;}

    // matrisi dosyaya yazdırma



    // matrisi dosyaya yazdırma
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
    public static void dosyaIceriginiSil(String dosyaYolu) throws IOException {
        // FileWriter kullanarak dosyayı boş bir dosya ile yeniden oluşturun
        FileWriter yazici = new FileWriter(dosyaYolu);
        yazici.close();
    }



    public void setObject() {
        int satir=0;
        int sutun=0;
        int sayac=0;


        // zumrut 37

        int a=0;
        sayac=0;
        for (int i = 0; i < 5; i++) {
            while (sayac<1)
            {
                gp.obj[a] = new OBJ_Zumrut();
                Random random=new Random();
                satir=random.nextInt(BOYUT);
                sutun = random.nextInt(BOYUT);
                if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
                    harita[satir][sutun] = 37;
                    sayac++;
                }
            }
            gp.obj[0].worldX =  satir* gp.tileSize;
            gp.obj[0].worldY = sutun * gp.tileSize;
            a++;
        }


        // altin2 42
        a=5;
        for (int i = 0; i < 5; i++) {
            gp.obj[a] = new OBJ_Gold();
            sayac=0;
            while (sayac<1)
            {
                Random random=new Random();
                satir=random.nextInt(BOYUT);
                sutun = random.nextInt(BOYUT);
                if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
                    harita[satir][sutun] = 42;
                    sayac++;
                }
            }
            gp.obj[a].worldX =  satir* gp.tileSize;
            gp.obj[a].worldY = sutun * gp.tileSize;
            a++;
        }



        // gumus 39
      a=10;
        for (int i = 0; i < 5; i++) {
            gp.obj[a] = new OBJ_Gumus();
            sayac=0;
            while (sayac<1)
            {
                Random random=new Random();
                satir=random.nextInt(BOYUT);
                sutun = random.nextInt(BOYUT);
                if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
                    harita[satir][sutun] = 39;
                    sayac++;
                }
            }
            gp.obj[a].worldX =  satir* gp.tileSize;
            gp.obj[a].worldY = sutun * gp.tileSize;
            a++;
        }


        // Bakir 40
        a=15;
        for (int i = 0; i < 5; i++) {
            gp.obj[a] = new OBJ_Bakir();
            sayac=0;

            while (sayac<1)
            {
                Random random=new Random();
                satir=random.nextInt(BOYUT);
                sutun = random.nextInt(BOYUT);
                if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
                    harita[satir][sutun] = 40;
                    sayac++;
                }
            }
            gp.obj[a].worldX =  satir* gp.tileSize;
            gp.obj[a].worldY = sutun * gp.tileSize;
            a++;
        }


        // zumrut 37

//        a=20;
//        sayac=0;
//        for (int i = 0; i < 5; i++) {
//            while (sayac<1)
//            {
//                gp.obj[a] = new OBJ_Zumrut22();
//                Random random=new Random();
//                satir=random.nextInt(BOYUT);
//                sutun = random.nextInt(BOYUT);
//                if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
//                    harita[satir][sutun] = 37;
//                    sayac++;
//                }
//            }
//            gp.obj[a].worldX =  satir* gp.tileSize;
//            gp.obj[a].worldY = sutun * gp.tileSize;
//            a++;
//        }


//        while (sayac<1)
//        {
//            gp.obj[a] = new OBJ_Zumrut();
//            Random random=new Random();
//            satir=random.nextInt(BOYUT);
//            sutun = random.nextInt(BOYUT);
//            if (harita[satir][sutun] == 0 || harita[satir][sutun] == 1) {
//                harita[satir][sutun] = 37;
//                sayac++;
//            }
//        }
//        gp.obj[a].worldX =  satir* gp.tileSize;
//        gp.obj[a].worldY = sutun * gp.tileSize;



        String dosyaYolu2="C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\ensonmatris.txt";

        matrisiDosyayaYaz(harita, dosyaYolu2);


    }


    public void setNPC() {

        String dosyaYolu = "C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\res1\\maps\\yeniMatris.txt";
        int[][] harita= haritayiOku(dosyaYolu);

        int sayac=0;
        int satir=0;
        int sutun=0;

        gp.npc[0]=new NPC_birdland(gp);
        sayac=0;
        while (sayac<1)
        {
            Random random=new Random();
            satir=random.nextInt(BOYUT);
            sutun = random.nextInt(BOYUT);
            if (      harita[satir][sutun] == 0
                    &&harita[satir+1][sutun] == 0
                    &&harita[satir+2][sutun] == 0
                    &&harita[satir+3][sutun] == 0
                    &&harita[satir+4][sutun] == 0
            ) {
                harita[satir][sutun] = 92;
                harita[satir+1][sutun] =92;
                harita[satir+2][sutun] =92;
                harita[satir+3][sutun] =92;
                harita[satir+4][sutun] =92;
                sayac++;
            }
        }
        gp.npc[0].worldX=gp.tileSize*satir+2;
        gp.npc[0].worldY=gp.tileSize*sutun;

        //bird snow
        gp.npc[1]=new NPC_birdSnow(gp);
        sayac=0;
        while (sayac<1)
        {
            Random random=new Random();
            satir=random.nextInt(BOYUT);
            sutun = random.nextInt(BOYUT);
            if (      harita[satir][sutun] == 1
                    &&harita[satir+1][sutun] == 1
                    &&harita[satir+2][sutun] == 1
                    &&harita[satir+3][sutun] == 1
                    &&harita[satir+4][sutun] == 1
            ) {
                harita[satir][sutun] = 93;
                harita[satir+1][sutun] =93;
                harita[satir+2][sutun] =93;
                harita[satir+3][sutun] =93;
                harita[satir+4][sutun] =93;
                sayac++;
            }
        }
        gp.npc[1].worldX=gp.tileSize*satir+2;
        gp.npc[1].worldY=gp.tileSize*sutun;


        // ari viz viz viz
        gp.npc[2]=new NPC_SnowAndLand(gp);
        sayac=0;
        while (sayac<1)
        {
            Random random=new Random();
            satir=random.nextInt(BOYUT);
            sutun = random.nextInt(BOYUT);
            if (      harita[satir][sutun] == 1
                    &&harita[satir+1][sutun] == 1
                    &&harita[satir+2][sutun] == 1
                    &&harita[satir+3][sutun] == 1
                    &&harita[satir+4][sutun] == 1
            ) {
                harita[satir][sutun] =  94;
                harita[satir+1][sutun] =94;
                harita[satir+2][sutun] =94;
                harita[satir+3][sutun] =94;
                harita[satir+4][sutun] =94;
                sayac++;
            }
        }
        gp.npc[2].worldX=gp.tileSize*satir+2;
        gp.npc[2].worldY=gp.tileSize*sutun;

        gp.npc[3]=new NPC_SnowAndLand(gp);
        sayac=0;
        while (sayac<1)
        {
            Random random=new Random();
            satir=random.nextInt(BOYUT);
            sutun = random.nextInt(BOYUT);
            if (      harita[satir][sutun] == 1
                    &&harita[satir+1][sutun] == 1
                    &&harita[satir+2][sutun] == 1
                    &&harita[satir+3][sutun] == 1
                    &&harita[satir+4][sutun] == 1
            ) {
                harita[satir][sutun] =  94;
                harita[satir+1][sutun] =94;
                harita[satir+2][sutun] =94;
                harita[satir+3][sutun] =94;
                harita[satir+4][sutun] =94;
                sayac++;
            }
        }
        gp.npc[3].worldX=gp.tileSize*satir+2;
        gp.npc[3].worldY=gp.tileSize*sutun;



        String dosyaYolu2 = "C:\\Users\\Didim1\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1_pazar\\res1\\maps\\ensonmatris.txt";

        matrisiDosyayaYaz(harita,dosyaYolu2);

        //arraylisti matrise aktarma
        System.out.println("serdarrrrrrrrrrrrr------------");
        for (int i = 0; i < BOYUT; i++) {
            for (int j = 0; j < BOYUT; j++) {
                int a =harita[i][j];
                System.out.print(" ");
                System.out.print(a);
            }
            System.out.println();
        }




    }





}