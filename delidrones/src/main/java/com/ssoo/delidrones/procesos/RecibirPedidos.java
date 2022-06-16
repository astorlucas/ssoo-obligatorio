package com.ssoo.delidrones.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Logger;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.negocio.Reloj;
import com.ssoo.delidrones.utils.MyLog;
import com.ssoo.delidrones.utils.UtilsClass;


public class RecibirPedidos implements Runnable {

  private int total;
  private Local mainLocal;
  Logger logger =  Logger.getLogger(this.getClass().getName());
  private MyLog log2File = new MyLog();
  private LinkedList<Pedido> preProc = new LinkedList<>();
  private Reloj reloj;

  public RecibirPedidos(Reloj reloj){
    this.reloj = reloj;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void setLocal(Local thisLocal) {
    this.mainLocal = thisLocal;
  }

  public void preProcessing(){
    String line = "";
    String splitBy = ",";
    try {
      File file = new File(
          "./src/main/resources/pedido.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      while ((line = br.readLine()) != null) {
        String[] linea = line.split(splitBy);
        Integer distance = Integer.parseInt(linea[3]);
        Pedido pedido = new Pedido(this.total + "", linea[0], linea[1], linea[2], distance);
        if(linea[0].contains("panchito")){
          preProc.addFirst(pedido);
        } else {
          preProc.addLast(pedido);
        }
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    this.preProcessing();
    while (this.total > 1) {
      for(Pedido pedido : preProc){
        UtilsClass.sleepRand(2, 4);
        LocalTime time = LocalTime.now();
        pedido.setTimeReceived(time.toNanoOfDay());
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        logger.info("El pedido: " + pedido.food + " fue recibido a las: " + timeStamp + " reloj " + reloj.counterDeliver);
        log2File.log(Thread.currentThread().getName(), pedido.food , "recibido", String.valueOf(0));
        UtilsClass.run(pedido);
        this.mainLocal.addPedido(pedido);
        this.total--;
      }

    }
  }

}
