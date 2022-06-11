package com.ssoo.delidrones.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.logging.Logger;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.utils.MyLog;
import com.ssoo.delidrones.utils.UtilsClass;

public class RecibirPedidos implements Runnable {

  private int total;
  private Local mainLocal;
  private Pedido pedido;
  //private Queue<Pedido> pedidos = new LinkedList<Pedido>();
  Logger logger =  Logger.getLogger(this.getClass().getName());
  private MyLog log2File = new MyLog();
  // public RecibirPedidos(int total, Local thisLocal) {
  // this.total = total;
  // this.mainLocal = thisLocal;
  // }

  public void setTotal(int total) {
    this.total = total;
  }

  public void setLocal(Local thisLocal) {
    this.mainLocal = thisLocal;
  }

  public void run() {

    while (this.total > 1) {

      // Pedido pedido;
      // Bloque de carga de pedidos por archivo
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
          // Random time to between orders based on time defined by file
          UtilsClass.sleepRand(5, 10 + distance);
          // New order created for every line
          Pedido pedido = new Pedido(this.total + "", linea[0], linea[1], linea[2], distance);
          LocalTime time = LocalTime.now();
          pedido.setTimeReceived(time.toNanoOfDay());
          //pedidos.add(pedido);
          String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
          logger.info("Te order: " + linea[0] + " was received at " + timeStamp);
          log2File.log(Thread.currentThread().getName(), linea[0] , "recibido");
          // Run every order lifecicle
          UtilsClass.run(pedido);
          // Add orders to the local
          this.mainLocal.addPedido(pedido);
          // Decrement total of orders
          this.total--;
        }
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

}
