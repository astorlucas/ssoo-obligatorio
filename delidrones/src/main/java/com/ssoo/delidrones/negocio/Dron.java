package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.datos.LocalDato;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dron implements Runnable {
    private UUID id;
    private String dueno;
    private Double bateria;
    private String ubicacion;
    private Boolean ava;
    private boolean cargando;
    private LocalDato esteLocal;

    public Dron(LocalDato esteLocal) {
        this.esteLocal = esteLocal;
    }

    public Dron(@JsonProperty("id") UUID id, @JsonProperty("dueno") String dueno,
            @JsonProperty("battery") Double bateria, 
            @JsonProperty("availability") Boolean ava) {
        this.id = id;
        this.dueno = dueno;
        this.bateria = bateria;
        this.ava = ava;
    }

    public String getDueno() {
        return dueno;
    }

    public Boolean getAvailability(){
        return true;
    }

    public void makeMeAvailable() throws InterruptedException{
        Thread.sleep(2000);
        this.setAva(true);
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

    public Boolean getAva() {
        return ava;
    }

    public void setAva(Boolean ava) {
        this.ava = ava;
    }

    @Override
    public void run() {
        //Recorrer los pedidos cocinados ponerle un flag de already asignados
        //demorar la entrega en base a un timeout fixed que viene en el archivo de pedidos
        //aunque los pedidos se siguen cocinando
        for(Pedido p : esteLocal.cookedOrders){
            System.out.println("Delivering order: " + this.id);
        }
        
    }

}
