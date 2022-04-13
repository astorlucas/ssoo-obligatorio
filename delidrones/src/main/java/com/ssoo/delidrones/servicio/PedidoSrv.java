package com.ssoo.delidrones.servicio;

import com.ssoo.delidrones.datos.PedidoDato;
import com.ssoo.delidrones.negocio.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class PedidoSrv {
    private final PedidoDato pedidoDato;

    @Autowired
    public PedidoSrv(@Qualifier("test") PedidoDato pedido){
        this.pedidoDato = pedido;
    }

    public int addPedido(Pedido pedido){
        return pedidoDato.insertPedido(pedido);
    }

    public ArrayList<Pedido> getAllPedidos(){
        return pedidoDato.selectAllPedidos();
    }
}
