package com.ssoo.delidrones.procesos;

import java.util.concurrent.Semaphore;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Pedido;

public class PrepararOrden implements Runnable{

    private LocalDato esteLocal;
    private Semaphore semaforo;

    public PrepararOrden(LocalDato esteLocal, Semaphore semaforo) {
        this.esteLocal = esteLocal;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        for(Pedido p : esteLocal.pedidos){
            Integer relativeTime = p.getPrepTime()*1;
            try {
                Thread.sleep(relativeTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The food " +p.getfoodName() + " is finished and added to the queue");
            esteLocal.cookedOrders.add(p);
            semaforo.release(1);
            //After it is finished, it is added done for delivery
        }
        
    }
    
}
