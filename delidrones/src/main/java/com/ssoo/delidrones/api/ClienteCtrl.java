package com.ssoo.delidrones.api;

import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.servicio.ClienteSrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/miapi/cliente")
@RestController
public class ClienteCtrl {

    private final ClienteSrv clienteServicio;

    @Autowired
    public ClienteCtrl(ClienteSrv cli){
        this.clienteServicio = cli;
    }

    @PostMapping
    public void addClient(@RequestBody Cliente cli){
        clienteServicio.addClient(cli);
    }
    
    
}
