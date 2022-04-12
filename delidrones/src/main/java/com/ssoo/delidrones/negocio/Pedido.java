package com.ssoo.delidrones.negocio;
import lombok.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    private int id;
    private int id_cliente;
    private List<Dron> drones;
    private TimeUnit tiempoEnvio;
    private int distancia;
    private TimeUnit horaInicio;
    private TimeUnit horaFin;

}
