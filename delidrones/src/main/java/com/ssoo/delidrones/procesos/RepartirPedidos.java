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
            System.out.println("TAMANO: " + esteLocal.cookedOrders.size());
            // Asigno los pedidos a los drones
            for (Dron dron : esteLocal.drons) {
                try {
                    semaforo.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("***********Status dron: " + dron.getBusy() + " order: " + dron.order);

                for (Pedido pedido : esteLocal.cookedOrders) {
                    if (pedido.getAssigned() == false && dron.order == null) {
                        dron.myOrder(pedido);
                        // esteLocal.cookedOrders.remove(pedido);
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                dron.myOrder(null);
                dron.setBusy(false);
            }
            // for (Pedido p : esteLocal.cookedOrders) {
            // try {
            // semaforo.acquire();
            // } catch (InterruptedException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }
            // for (Dron d : esteLocal.drons) {

            // // Si no se ha hecho el delivery y el dron está disponible
            // if (p.getDelivered() == false) && d.getBusy() == false) {
            // System.out.println("Delivering order: " + p.getfoodName() + " with dron: " +
            // d.getId());
            // p.setDelivered(true);
            // // Pedido cookedOrder = esteLocal.cookedOrders.remove();
            // }
            // }

            // }
        }

    }

}
