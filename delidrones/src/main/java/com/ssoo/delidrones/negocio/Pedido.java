package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.procesos.Watched;
import com.ssoo.delidrones.utils.UtilsClass;

import lombok.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class Pedido extends Watched {

    public static final String INGRESADO = "ingresado";
    public static final String EN_PROCESO = "en-proceso";
    public static final String PREPARADO = "preparado";
    public int prepTime;
    public String id;
    public String state;
    public int distance;

    public Pedido(String id, String state, int prepTime) {
        super(id, state);
        this.prepTime = prepTime;
    }

    public Pedido(@JsonProperty("id") String id, @JsonProperty("state") String state,
            @JsonProperty("preptime") int prepTime, @JsonProperty("distance") int distance) {
        super(id, state);
        this.id = id;
        this.state = state;
        this.prepTime = prepTime;
        this.distance = distance;
    }

    @Override
    public void run() {

        this.mainLocal.changeState(this, INGRESADO);

        UtilsClass.sleepRand(2, 6);

        this.mainLocal.changeState(this, EN_PROCESO);

        UtilsClass.sleepRand(2, 6);

        this.mainLocal.changeState(this, PREPARADO);

    }

    public int getPrepTime() {
        return this.prepTime;
    }

    public static String getIngresado() {
        return INGRESADO;
    }

    public static String getEnProceso() {
        return EN_PROCESO;
    }

    public static String getPreparado() {
        return PREPARADO;
    }

}
