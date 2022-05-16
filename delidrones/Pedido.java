package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    private UUID id;
    private List<Dron> drones;
    private String origen;
    private int distancia;
    private String destino;
    private String horaFin;
    private String local;
    private Boolean delivered;
    private String foodName;
    private Integer prepTime;

    public Pedido(@JsonProperty("id") UUID id, @JsonProperty("cli") String foodName,
            @JsonProperty("origen") String origen, @JsonProperty("dist") int distancia,
            @JsonProperty("destino") String destino, @JsonProperty("fin") String horaFin,
            @JsonProperty("local") String local,
            @JsonProperty("done") Boolean delivered,
            @JsonProperty("time") Integer prepTime) {
        this.id = id;
        this.foodName = foodName;
        this.origen = origen;
        this.distancia = distancia;
        this.destino = destino;
        this.horaFin = horaFin;
        this.local = local;
        this.delivered = delivered;
        this.prepTime = prepTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getfoodName() {
        return foodName;
    }

    public List<Dron> getDrones() {
        return drones;
    }

    public void setDrones(List<Dron> drones) {
        this.drones = drones;
    }

    public String getOrigen() {
        return origen;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDestino() {
        return destino;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

}
