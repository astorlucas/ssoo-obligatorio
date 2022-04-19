package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    private UUID id;
    private int id_cliente;
    private List<Dron> drones;
    private String tiempoEnvio;
    private int distancia;
    private String horaInicio;
    private String horaFin;

    public Pedido(@JsonProperty("id") UUID id, @JsonProperty("cli") int id_cliente,
            @JsonProperty("origen") String tiempoEnvio, @JsonProperty("dist") int distancia,
            @JsonProperty("destino") String horaInicio, @JsonProperty("fin") String horaFin) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.tiempoEnvio = tiempoEnvio;
        this.distancia = distancia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Dron> getDrones() {
        return drones;
    }

    public void setDrones(List<Dron> drones) {
        this.drones = drones;
    }

    public String getTiempoEnvio() {
        return tiempoEnvio;
    }

    public void setTiempoEnvio(String tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

}
