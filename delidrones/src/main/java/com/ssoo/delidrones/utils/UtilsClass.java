package com.ssoo.delidrones.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class UtilsClass {

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepRand(int min, int max) {
        sleep(ThreadLocalRandom.current().nextInt(min, max + 1));
    }

    public static void run(Runnable runnable) {
        (new Thread(runnable)).start();
    }

    public static int ordersSize() {
        int size = 0;
        String line = "";
        String splitBy = ",";
        try {
            File file = new File(
                    "./src/main/resources/pedido.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(splitBy);
                size++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

}
