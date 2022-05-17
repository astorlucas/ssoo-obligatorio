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
public class Dron {
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

}
