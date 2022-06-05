package com.ssoo.delidrones.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.procesos.RecibirPedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LocalSrv {
    
    // private final Local mainLocal;

    // @Autowired
    // public LocalSrv(@Qualifier("mainLocal") Local mainLocal) {
    //     this.mainLocal = mainLocal;
    // }

    // public int insertPedido(Pedido pedido) {

    //     return mainLocal.insertPedido(pedido);
        
    // }

}
