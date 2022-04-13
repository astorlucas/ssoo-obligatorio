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
    private int bateria;
    private String ubicacion;
    private boolean ocupado;
    private boolean cargando;

    public Dron(@JsonProperty("id") UUID id) {

        this.id = id;

    }

}
