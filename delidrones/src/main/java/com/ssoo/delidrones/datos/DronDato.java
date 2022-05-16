package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Repository("dron")

public class DronDato implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    private static ArrayList<Dron> drons = new ArrayList<>();
    // private final PedidoDato pedidoDato;

    // public DronDato(PedidoDato pedidoDato, ArrayList<String> historyDeliver) {
    // this.pedidoDato = pedidoDato;
    // this.historyDeliver = historyDeliver;
    // }

    // public ArrayList<String> historyDeliver = new ArrayList<>();

    // public int insertDron(Dron dron) {
    //     UUID id = UUID.randomUUID();
    //     drons.add(new Dron(id, dron.getDueno(), dron.getBateria(), dron.getAva()));
    //     return 1;
    // }

    public ArrayList<Dron> selectAllDrones() {
        return drons;
    }

    // public ArrayList<String> returnHistory() {
    // return historyDeliver;
    // }

    // // TO-DO ask if thread is finished b4 keep adding orders (simulates shipping)
    // @Override
    // public void run() {

    // ArrayList<Pedido> pedidos = pedidoDato.selectAllPedidos();
    // for (Pedido p : pedidos) {

    // historyDeliver.add(p.getDestino() + p.getOrigen());
    // try {
    // Thread.sleep(400000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // }

    

}
