package com.ssoo.delidrones.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LocalSrv {
    private final LocalDato localDato;

    @Autowired
    public LocalSrv(@Qualifier("local") LocalDato localDato) {
        this.localDato = localDato;
    }

    public int addLocal(Local local) {
        return localDato.insertLocal(local);
    }

    public ArrayList<Local> getAllLocals() {
        return localDato.selectAllLocals();
    }

    public HashMap<String, String> getProcesados() {
        return LocalDato.pedidoYDron;
    }


    public int addPedido(Pedido pedido) {
        return localDato.insertPedido(pedido);
    }

    public int addDron(Dron dron) {
        return localDato.insertDron(dron);
    }

    public List<Pedido> getAllPedidos() {
        return localDato.selectAllPedidos();
    }

    public List<Dron> getAllDrones() {
        return localDato.selectAllDrones();
    }
}
