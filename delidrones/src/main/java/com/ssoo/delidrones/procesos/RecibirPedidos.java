package com.ssoo.delidrones.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.utils.UtilsClass;

public class RecibirPedidos implements Runnable {

  private int total;
  private Local mainLocal;

  public RecibirPedidos(int total, Local thisLocal) {
    this.total = total;
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
            "./src/main/resources/newPedido.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
          String[] linea = line.split(splitBy);
          // Random time to between orders
          UtilsClass.sleepRand(5, 10);
          //New order created for every line
          Integer prepTime = Integer.parseInt(linea[0]);
          Pedido pedido = new Pedido(this.total + "", "Pedido " + this.total + "time " + prepTime, prepTime);
          //Run every order lifecicle
          UtilsClass.run(pedido);
          //Add orders to the local
          this.mainLocal.addPedido(pedido);
          //Decrement total of orders
          this.total--;
        }
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      // Bloque de carga de pedidos por archivo

    }

  }

}
