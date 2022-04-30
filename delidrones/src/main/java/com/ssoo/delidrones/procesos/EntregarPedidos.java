package com.ssoo.delidrones.procesos;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class EntregarPedidos implements Runnable {

    private LocalDato esteLocal;

    public EntregarPedidos(LocalDato local) {
        this.esteLocal = local;
    }

    @Override
    public void run() {
        while (true) {
            //as for online order taking, DONE
            //assignation taking for local DONE
            for (Pedido p : esteLocal.cookedOrders) {
                for (Dron d : esteLocal.drons) {
                    if (p.getLocal().equals(d.getDueno()) && p.getDelivered() == false && d.getAva() == true) { // Compare for distance
                        esteLocal.pedidoYDron.put(p.getLocal(), d.getDueno());
                        System.out.println("Estoy asignando PEDIDO: "+ p.getLocal() + " DRON: " + d.getDueno());
                        p.setDelivered(true);
                        d.setAva(false);
                        //TO-DO make drones available once the delivery is done
                    }
                }
            }

        }

    }
}
