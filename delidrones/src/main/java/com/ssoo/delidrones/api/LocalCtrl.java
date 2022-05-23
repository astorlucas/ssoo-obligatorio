package com.ssoo.delidrones.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.procesos.RecibirPedidos;
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

    private final LocalSrv localService;

    @Autowired
    public LocalCtrl(LocalSrv localService) {
        this.localService = localService;
    }

    @PostMapping
    public void insertPedido(@RequestBody Pedido pedido){
        localService.insertPedido(pedido);
    }

}
