package com.ssoo.delidrones.procesos;

import java.util.concurrent.Semaphore;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

public class RepartirPedidos implements Runnable {

    private Semaphore semaforo;
    private LocalDato esteLocal;

    public RepartirPedidos(Semaphore semaforo, LocalDato esteLocal) {
        this.semaforo = semaforo;
        this.esteLocal = esteLocal;
    }

    @Override
    public void run() {
        // Recorrer los pedidos cocinados ponerle un flag de already asignados
        // demorar la entrega en base a un timeout fixed que viene en el archivo de
        // pedidos
        // aunque los pedidos se siguen cocinando
        while (true) {
            // Asigno los pedidos a los drones
            for (Dron dron : esteLocal.drons) {
                try {
                    semaforo.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("***********Status dron: " + dron.getBusy() + " order: " + dron.order);

                for (Pedido pedido : esteLocal.cookedOrders) {
                    if (pedido.getAssigned() == false && dron.order == null) {
                        dron.myOrder(pedido);
                        pedido.setAssigned(true);
                        dron.setBusy(true);
                        System.out
                                .println("This dron: " + dron.getId() + " has this order: "
                                        + dron.order.getfoodName() + " dron: " + dron.getDueno());
                    }

                }

            }
            for (Dron dron : esteLocal.drons) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dron.myOrder(null);
                dron.setBusy(false);
            }
        }

    }

}