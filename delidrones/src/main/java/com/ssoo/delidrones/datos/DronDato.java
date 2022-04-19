package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository("dron")

public class DronDato implements Runnable {
    private static ArrayList<Dron> lista = new ArrayList<>();
    private final PedidoDato pedidoDato;
    
    public DronDato(PedidoDato pedidoDato, ArrayList<String> historyDeliver) {
        this.pedidoDato = pedidoDato;
        this.historyDeliver = historyDeliver;
    }

    public ArrayList<String> historyDeliver = new ArrayList<>();

    public int insertDron(Dron dron){
        UUID id = UUID.randomUUID();
        lista.add(new Dron(id));
        return 1;
    }

    public ArrayList<Dron> selectAllDrones(){
        return lista;
    }

    public ArrayList<String> returnHistory(){
        return historyDeliver;
    }

    @Override
    public void run() {
        
        ArrayList<Pedido> pedidos = pedidoDato.selectAllPedidos();
        for(Pedido p : pedidos){
            
            historyDeliver.add(p.getTiempoEnvio() + p.getHoraInicio());
        }
        
    }


}
