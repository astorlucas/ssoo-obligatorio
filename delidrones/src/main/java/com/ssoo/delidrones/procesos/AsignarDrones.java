package com.ssoo.delidrones.procesos;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsignarDrones implements Runnable {

    private LocalDato esteLocal;

    public AsignarDrones(LocalDato local) {
        this.esteLocal = local;
    }

    @Override
    public void run() {
        while (true) {
            // for (Pedido p : esteLocal.pedidos) {
            //     if (p.getDelivered() == false) {
            //         System.out.println("PEDIDO PROC: " + p.getOrigen());
            //         for (Dron d : esteLocal.drons) {
            //             System.out.println("DRON PROC: " + d.getDueno());
            //             try {
            //                 Thread.sleep(1000);
            //             } catch (InterruptedException e) {
            //                 // TODO Auto-generated catch block
            //                 e.printStackTrace();
            //             }
            //             esteLocal.pedidoYDron.put("Origen: " + p.getOrigen(), "DUEÑO: " + d.getDueno());
            //             p.setDelivered(true);
            //         }
            //     }
            // }
            for(Pedido p : esteLocal.pedidos){
                for(Dron d : esteLocal.drons){
                    if(p.getLocal().equals(d.getDueno())){ //Compare for distance
                        esteLocal.pedidoYDron.put(p.getLocal(), d.getDueno());
                    }
                }
            }
        }

    }
}
