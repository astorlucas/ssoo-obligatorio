package com.ssoo.delidrones.api;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.servicio.DronSrv;
import com.ssoo.delidrones.servicio.DronSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("api/miapi/dron")
@RestController
public class DronCtrl {

    private final DronSrv dronServicio;

    @Autowired
    public DronCtrl(DronSrv dron){
        this.dronServicio = dron;
    }

    @PostMapping
    public void addDron(@RequestBody Dron dron){
        dronServicio.addDron(dron);
    }

    @GetMapping
    public ArrayList<Dron> getAllDrones(){
        return dronServicio.getAllDrones();
    }

}
