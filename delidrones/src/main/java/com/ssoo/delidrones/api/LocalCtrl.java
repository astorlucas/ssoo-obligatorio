package com.ssoo.delidrones.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
//import com.ssoo.delidrones.procesos.EntregarPedidos;
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
    public void addLocal(@RequestBody Local local) {
        localServicio.addLocal(local);
    }

    @GetMapping
    public ArrayList<Local> getAllLocals() {
        return localServicio.getAllLocals();
    }

    // example to get first element
    @RequestMapping(value = "/primero", method = RequestMethod.GET)
    public Local getFirstLocal() {
        return localServicio.getAllLocals().remove(1);
    }

    @RequestMapping(value = "/procesados", method = RequestMethod.GET)
    public HashMap<String, String> getProcesados() {
        return localServicio.getProcesados();
    }

    @RequestMapping(value = "/addpedido", method = RequestMethod.POST)
    public void addPedido(@RequestBody Pedido pedido) {
        localServicio.addPedido(pedido);
    }

    @RequestMapping(value = "/getpedidos", method = RequestMethod.GET)
    public List<Pedido> getAllPedidos() {
        return localServicio.getAllPedidos();
    }

    @RequestMapping(value = "/adddron", method = RequestMethod.POST)
    public void addDron(@RequestBody Dron dron) {
        localServicio.addDron(dron);
    }

    @RequestMapping(value = "/getdrones", method = RequestMethod.POST)
    public List<Dron> getAllDrones() {
        return localServicio.getAllDrones();
    }

}
