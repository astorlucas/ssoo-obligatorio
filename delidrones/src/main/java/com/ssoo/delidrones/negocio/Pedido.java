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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido extends Watched {

    public static final String INGRESADO = "ingresado";
    public static final String EN_PROCESO = "en-proceso";
    public static final String PREPARADO = "preparado";

    public Pedido(String id, String state) {
        super(id, state);
    }

    @Override
    public void run() {

        this.mainLocal.changeState(this, INGRESADO);

        UtilsClass.sleepRand(2, 6);

        this.mainLocal.changeState(this, EN_PROCESO);

        UtilsClass.sleepRand(2, 6);

        this.mainLocal.changeState(this, PREPARADO);

    }

}
