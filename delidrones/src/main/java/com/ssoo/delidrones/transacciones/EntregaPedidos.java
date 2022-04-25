package com.ssoo.delidrones.transacciones;

import java.io.IOException;
import java.nio.CharBuffer;

import com.ssoo.delidrones.datos.LocalDato;

public class EntregaPedidos implements Runnable {

    private LocalDato esteLocal;

    public EntregaPedidos(LocalDato local){
        this.esteLocal = local;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
}
