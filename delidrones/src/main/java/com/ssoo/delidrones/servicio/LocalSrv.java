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

    public ArrayList<Dron> dronesDeLocal(String name) {
        return LocalDato.dronesDeLocal(name);
    }

    // Esto es para probar añadiendo directamente en la lista que a mi me interesa
    // ir recorriendo.
    public int addPedido(Pedido pedido) {
        return localDato.insertPedido(pedido);
    }

    public List<Pedido> getAllPedidos() {
        return localDato.selectAllPedidos();
    }

    // public int addDron(Dron dron) {
    //     return localDato.insertDron(dron);
    // }

    public List<Dron> getAllDrones() {
        return localDato.selectAllDrones();
    }

    // Esto es para probar añadiendo directamente en la lista que a mi me interesa
    // ir recorriendo.

}
