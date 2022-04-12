package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Cliente {

    private int id;
    private String name;
    private String ubicacion;

    public Cliente(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
