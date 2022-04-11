package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {

    private final String name;

    public Cliente(@JsonProperty("name") String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    
}
