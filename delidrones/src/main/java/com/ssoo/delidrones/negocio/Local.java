package com.ssoo.delidrones.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Local {

    private UUID id;
    private String name;
    private String adress;
    private boolean isStation;
    public static ArrayList<Pedido> orders = new ArrayList<>();
    

    public Local(@JsonProperty("id") UUID id, 
    @JsonProperty("name") String name,
    @JsonProperty("adress") String adress,
    @JsonProperty("station") boolean isStation){

        this.id = id;
        this.name = name;
        this.adress = adress;
        this.isStation = isStation;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isStation() {
        return isStation;
    }

    public void setStation(boolean isStation) {
        this.isStation = isStation;
    }

    
    
}
