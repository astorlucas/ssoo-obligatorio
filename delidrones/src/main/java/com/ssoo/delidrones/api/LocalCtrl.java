package com.ssoo.delidrones.api;

import java.util.ArrayList;

import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.servicio.LocalSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/miapi/local")
@RestController
public class LocalCtrl {
    
    private final LocalSrv localServicio;

    @Autowired
    public LocalCtrl(LocalSrv localServicio) {
        this.localServicio = localServicio;
    }

    @PostMapping
    public void addLocal(@RequestBody Local local){
        localServicio.addLocal(local);
    }

    @GetMapping
    public ArrayList<Local> getAllLocals(){
        return localServicio.getAllLocals();
    }

    //example to get first element
    @RequestMapping(value = "/primero" , method = RequestMethod.GET)
    public Local getFirstLocal(){
        return localServicio.getAllLocals().remove(1);
    }
}
