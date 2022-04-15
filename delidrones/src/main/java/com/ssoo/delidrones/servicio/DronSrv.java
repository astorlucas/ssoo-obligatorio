package com.ssoo.delidrones.servicio;

import com.ssoo.delidrones.datos.DronDato;
import com.ssoo.delidrones.negocio.Dron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DronSrv {

    private final DronDato dronDato;

    @Autowired
    public DronSrv(@Qualifier("dron") DronDato dron){
        this.dronDato = dron;
    }

    public int addDron(Dron dron){
        return dronDato.insertDron(dron);
    }

    public ArrayList<Dron> getAllDrones(){
        return dronDato.selectAllDrones();
    }

}
