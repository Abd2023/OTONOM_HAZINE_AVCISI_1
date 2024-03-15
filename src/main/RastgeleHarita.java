package main;

import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class RastgeleHarita {
    public  void haritaolustur()  {
        String dosyaYolu = "C:\\Users\\Abdullah Amin\\IdeaProjects\\OTONOM_HAZINE_AVCISI_1\\res1\\maps\\harita.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);


        int soltaraf=0;
        int sagtaraf=1;

        for (int i = 0; i < 50; i++) {
            //sol taraf
            for (int j = 0; j < 25; j++) {
                if(i==0 || i==49 || j==0)
                {
                    printWriter.printf("%d ", 8);
                }
                else {
                    printWriter.printf("%d ", soltaraf);
                }

            }
            //sag taraf
            for(int j=25; j<50;j++)
            {
                if(i==0 || i==49 || j==49)
                {
                    printWriter.printf("%d ", 12);
                }
                else {
                    printWriter.printf("%d ", sagtaraf);

                }
            }

            printWriter.println();
        }



        printWriter.close();
        System.out.println("Harita oluşturuldu: " + dosyaYolu);
    }
}