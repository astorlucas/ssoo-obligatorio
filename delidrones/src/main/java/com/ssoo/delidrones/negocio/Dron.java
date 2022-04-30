package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dron {
    private UUID id;
    private String dueno;
    private Double bateria;
    private String ubicacion;
    private Boolean ava;
    private boolean cargando;

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

}
