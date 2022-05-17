package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Repository("dron")

public class DronDato {

    private static ArrayList<Dron> drons = new ArrayList<>();

    public ArrayList<Dron> selectAllDrones() {
        return drons;
    }

    

}
