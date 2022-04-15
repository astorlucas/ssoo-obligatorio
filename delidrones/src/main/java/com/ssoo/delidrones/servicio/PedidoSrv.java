package com.ssoo.delidrones.servicio;

import com.ssoo.delidrones.datos.PedidoDato;
import com.ssoo.delidrones.negocio.Pedido;

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

    //adding a logger for debug
    Logger logger = LoggerFactory.getLogger(PedidoSrv.class);
    
    private final PedidoDato pedidoDato;

    @Autowired
    public PedidoSrv(@Qualifier("pedido") PedidoDato pedido){
        this.pedidoDato = pedido;
    }

    public int addPedido(Pedido pedido){
        return pedidoDato.insertPedido(pedido);
    }

    public ArrayList<Pedido> getAllPedidos(){
        return pedidoDato.selectAllPedidos();
    }

    //test async method to get shipping price
    //not sure what completable futures does, yet
    @Async
    public  CompletableFuture<Double>  getShippingPrice(String stockName) throws InterruptedException {
        logger.info("Starting: getShippingPrice for order {} with thread {}", stockName, Thread.currentThread().getName());
        Thread.sleep(1000);
        Double price;
        switch (stockName) {
            case "order1":
                price = 50.0;
                break;
            case "order2":
                price = 20.0;
                break;
            case "order3":
                price= 15.0;
                break;
            default:
                price = null;

        }
        logger.info("Complete: getShippingPrice for order {} with thread {}", stockName, Thread.currentThread().getName());

        return CompletableFuture.completedFuture(price);
    }
}
