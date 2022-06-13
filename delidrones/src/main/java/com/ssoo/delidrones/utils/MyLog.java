package com.ssoo.delidrones.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyLog {
    static String fileDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    private static final String logPath = "./src/logs/log" + fileDate + ".csv";

    public void log(String threadName, String msg, String event, String timeToEvent) {
        File f;
        FileWriter fw;
        String timeStamp;
        try {

            timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            f = new File(logPath);
            fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(timeStamp + "," + threadName + "," + msg + "," + event + "," + timeToEvent);
            bw.newLine();

            bw.close();
            fw.close();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
