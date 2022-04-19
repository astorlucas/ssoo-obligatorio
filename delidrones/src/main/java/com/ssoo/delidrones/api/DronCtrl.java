package com.ssoo.delidrones.api;

import com.ssoo.delidrones.datos.DronDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.servicio.DronSrv;
import com.ssoo.delidrones.servicio.DronSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("api/miapi/dron")
@RestController
public class DronCtrl {

    private final DronSrv dronServicio;
    private final DronDato dronDato;

    @Autowired
    public DronCtrl(DronSrv dron, DronDato dronDato){
        this.dronServicio = dron;
        this.dronDato = dronDato;
    }

    @PostMapping
    public void addDron(@RequestBody Dron dron){
        dronServicio.addDron(dron);
    }

    @GetMapping
    public ArrayList<Dron> getAllDrones(){
        return dronServicio.getAllDrones();
    }

    @RequestMapping(value = "/delivering" , method = RequestMethod.GET)
    public ArrayList<String> allDeliveries(){
        Thread hilo1 = new Thread(dronDato,"Hilo pedidos");
        hilo1.start();
        return dronServicio.history();
    }

}
