package com.ssoo.delidrones.negocio;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Cliente {

    private UUID id;
    private String name;
    private String adress;
    private String order;

    public Cliente(@JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("adress") String adress,
            @JsonProperty("order") String order) {

        this.id = id;
        this.name = name;
        this.order = order;
        this.adress = adress;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getOrder() {
        return this.order;
    }

    public String getAdress() {
        return this.adress;
    }

}
