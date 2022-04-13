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
    private TimeUnit tiempoEnvio;
    private int distancia;
    private TimeUnit horaInicio;
    private TimeUnit horaFin;
    public Pedido(@JsonProperty("id") UUID id) {
        this.id = id;
    }


}
