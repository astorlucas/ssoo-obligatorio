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
            Integer relativeTime = p.getPrepTime()*10;
            try {
                Thread.sleep(relativeTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The food " +p.getfoodName() + " is finished and added to the queue");
            esteLocal.cookedOrders.add(p);
            //After it is finished, it is added done for delivery
        }
        
    }
    
}
