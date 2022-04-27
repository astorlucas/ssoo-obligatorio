package com.ssoo.delidrones.api;

import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.servicio.PedidoSrv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RequestMapping("api/miapi/pedido")
@RestController
public class PedidoCtrl {

    private final PedidoSrv pedidoServicio;

    @Autowired
    public PedidoCtrl(PedidoSrv pedido){
        this.pedidoServicio = pedido;
    }

    @PostMapping
    public void addPedido(@RequestBody Pedido pedido){
        pedidoServicio.addPedido(pedido);
    }

    @GetMapping
    public ArrayList<Pedido> getAllPedidos(){
        return pedidoServicio.getAllPedidos();
    }
}
