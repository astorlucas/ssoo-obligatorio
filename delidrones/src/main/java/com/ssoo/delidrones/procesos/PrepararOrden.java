package com.ssoo.delidrones.procesos;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Pedido;

public class PrepararOrden implements Runnable{

    private LocalDato esteLocal;

    public PrepararOrden(LocalDato esteLocal) {
        this.esteLocal = esteLocal;
    }

    @Override
    public void run() {
        for(Pedido p : esteLocal.pedidos){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("I'm waiting until it is finished");
            esteLocal.cookedOrders.add(p);
        }
        
    }
    
}
