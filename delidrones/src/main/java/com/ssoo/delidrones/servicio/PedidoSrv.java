package com.ssoo.delidrones.servicio;

import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.procesos.RecibirPedidos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service

public class PedidoSrv {

    // // adding a logger for debug
    // Logger logger = LoggerFactory.getLogger(PedidoSrv.class);

    // private final PedidoDato pedidoDato;
    private RecibirPedidos receptor;

    // @Autowired
    // public PedidoSrv(@Qualifier("local") Pedido pedido) {
    //     this.receptor.mainPedido = pedido;
    // }


    // public int addPedido(Pedido pedido) {
    //     return pedidoDato.insertPedido(pedido);
    // }

    // public ArrayList<Pedido> getAllPedidos() {
    //     return pedidoDato.selectAllPedidos();
    // }

}
