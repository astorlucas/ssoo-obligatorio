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
    private boolean ocupado;
    private boolean cargando;

    public Dron(@JsonProperty("id") UUID id, @JsonProperty("dueno") String dueno,
            @JsonProperty("battery") Double bateria) {
        this.id = id;
        this.dueno = dueno;
        this.bateria = bateria;
    }

    public String getDueno() {
        return dueno;
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

}
