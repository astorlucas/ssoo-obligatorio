package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.procesos.Watched;
import com.ssoo.delidrones.utils.UtilsClass;

import lombok.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido extends Watched {

    Logger logger =  Logger.getLogger(this.getClass().getName());
    public static final String INGRESADO = "ingresado";
    public static final String EN_PROCESO = "en-proceso";
    public static final String PREPARADO = "preparado";
    public String id;
    public String state;
    public int distance;
    public UUID uid;
    public String destiny;
    public String food;

    public Pedido(String id, String food, String destino, String state, int distance) {
        super(id, state);
        this.id = id;
        this.uid = UUID.randomUUID();
        this.state = state;
        this.distance = distance;
        this.destiny = destino;
        this.food = food;
    }

    @Override
    public void run() {

        this.mainLocal.changeState(this, INGRESADO);

        UtilsClass.sleepRand(2, 6);

        this.mainLocal.changeState(this, EN_PROCESO);

        UtilsClass.sleepRand(this.distance, this.distance);

        this.mainLocal.changeState(this, PREPARADO);
        
        

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

}
