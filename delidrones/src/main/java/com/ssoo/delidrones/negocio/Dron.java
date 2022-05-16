package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.datos.LocalDato;

import lombok.*;

import java.util.UUID;
import java.util.concurrent.Semaphore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dron implements Runnable {
    private UUID id;
    private String dueno;
    private Double bateria;
    private String ubicacion;
    private Boolean busy;
    private boolean cargando;
    private LocalDato esteLocal;
    public Semaphore semaforo;
    public Pedido order;

    public Dron(LocalDato esteLocal) {
        this.esteLocal = esteLocal;
    }

    public Dron(@JsonProperty("id") UUID id, @JsonProperty("dueno") String dueno,
            @JsonProperty("battery") Double bateria,
            @JsonProperty("busy") Boolean busy) {
        this.id = id;
        this.dueno = dueno;
        this.bateria = bateria;
        this.busy = busy;
        // this.semaforo = semaphore;
    }

    public String getDueno() {
        return dueno;
    }

    public void myOrder(Pedido order) {
            this.order = order;

    }

    public void makeMeAvailable() throws InterruptedException {
        Thread.sleep(2000);
        this.setBusy(false);
        this.myOrder(null);
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public Double getBateria() {
        return bateria;
    }

    public void setBateria(Double bateria) {
        this.bateria = bateria;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean ava) {
        this.busy = ava;
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    // @Override
    // public void run() {
    // // Recorrer los pedidos cocinados ponerle un flag de already asignados
    // // demorar la entrega en base a un timeout fixed que viene en el archivo de
    // // pedidos
    // // aunque los pedidos se siguen cocinando
    // while (true) {
    // for (Pedido p : esteLocal.cookedOrders) {
    // try {
    // semaforo.acquire();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // //Si no se ha hecho el delivery y el dron está disponible
    // if (p.getDelivered() == false && this.getBusy() == false) {
    // System.out.println("Delivering order: " + p.getfoodName() + " with dron: " +
    // this.id);
    // p.setDelivered(true);
    // Pedido cookedOrder = esteLocal.cookedOrders.remove();
    // }
    // //this.setBusy(true);

    // }
    // }

    // }
}
