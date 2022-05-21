package com.ssoo.delidrones.procesos;

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
  
        UtilsClass.sleepRand(5, 10);
  
        Pedido pedido = new Pedido(this.total + "", "Pedido " + this.total);
  
        UtilsClass.run(pedido);
  
        this.mainLocal.addPedido(pedido);
  
        this.total--;
  
      }
  
    }
    
}
