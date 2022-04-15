package com.ssoo.delidrones.api;

import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.servicio.PedidoSrv;
import com.ssoo.delidrones.config.AsyncConfig;

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

    private final ThreadPoolTaskExecutor taskExecutor;

    Logger logger = LoggerFactory.getLogger(PedidoCtrl.class);

    @Autowired
    public PedidoCtrl(PedidoSrv pedido, ThreadPoolTaskExecutor taskExecutor){
        this.pedidoServicio = pedido;
        this.taskExecutor = taskExecutor;
    }

    @PostMapping
    public void addPedido(@RequestBody Pedido pedido){
        pedidoServicio.addPedido(pedido);
    }

    @GetMapping
    public ArrayList<Pedido> getAllPedidos(){
        return pedidoServicio.getAllPedidos();
    }

    @RequestMapping(value = "/getShippingPrices" , method = RequestMethod.GET)
    public ResponseEntity getAllStockPrices() {

        List<Double> stockPrices  = getAllThreeShippingPrices();
        List<String> stockPriceStrings = stockPrices.stream().map(Object::toString).collect(Collectors.toList());

        return ResponseEntity.ok().body(String.join(",", stockPriceStrings));
    }
    
    public List<Double> getAllThreeShippingPrices() {
        List<Double> stockPriceList = new ArrayList<>();
        CompletableFuture<Double> cf1, cf2, cf3;
        try {
            logger.info("Calling async getShippingPrice for order1, active count: {}, Pool size: {}, Queue Size: {}", taskExecutor.getActiveCount(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().size());
            cf1 = pedidoServicio.getShippingPrice("order1");
            logger.info("Calling async getShippingPrice for order2, active count: {}, Pool size: {}, Queue Size: {}", taskExecutor.getActiveCount(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().size());

            cf2 = pedidoServicio.getShippingPrice("order2");
            logger.info("Calling async getShippingPrice for order3, active count: {}, Pool size: {}, Queue Size: {}", taskExecutor.getActiveCount(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().size());

            cf3 = pedidoServicio.getShippingPrice("order3");
            logger.info("After three calls to async getShippingPrice, active count: {}, Pool size: {}, Queue Size: {}", taskExecutor.getActiveCount(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().size());

            // Monitor the threads as they complete.
            int sleeptime = 0;
            for(int i = 0; i < 20; i++) {
                Thread.sleep(100);
                sleeptime=(i+1)*100;
                logger.info("After {} milliseconds, active count: {}, Pool size: {}, Queue Size: {}", sleeptime, taskExecutor.getActiveCount(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().size());
            }
            stockPriceList.add(cf1.get());
            stockPriceList.add(cf2.get());
            stockPriceList.add(cf3.get());
        }
        catch (Exception e) {
            System.out.println("error " + e);
        }

        return stockPriceList;

    }



}
