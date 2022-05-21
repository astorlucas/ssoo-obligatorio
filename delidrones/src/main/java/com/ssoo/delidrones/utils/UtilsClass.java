package com.ssoo.delidrones.utils;

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

}
