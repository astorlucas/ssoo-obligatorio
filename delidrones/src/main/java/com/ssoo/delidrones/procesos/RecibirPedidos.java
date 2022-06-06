package com.ssoo.delidrones.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;

import java.util.Queue;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.utils.UtilsClass;
import org.springframework.stereotype.Repository;

public class RecibirPedidos implements Runnable {

  private int total;
  private Local mainLocal;
  private Pedido pedido;
  private Queue<Pedido> pedidos = new LinkedList<Pedido>();

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
          Integer prepTime = Integer.parseInt(linea[0]);
          Integer distance = Integer.parseInt(linea[3]);
          // Random time to between orders based on time defined by file
          UtilsClass.sleepRand(5, 10 + prepTime);
          // New order created for every line
          Pedido pedido = new Pedido(this.total + "",prepTime, linea[1],linea[2],distance);
          pedidos.add(pedido);
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
