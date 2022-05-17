package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Pedido;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.UUID;

@Repository("pedido")

public class PedidoDato {

    public static ArrayList<Pedido> orders = new ArrayList<>();

    public int insertPedido(Pedido cli) {
        UUID id = UUID.randomUUID();
        orders.add(new Pedido(id, cli.getfoodName(), cli.getDestino(), cli.getDistancia(), cli.getOrigen(),
                cli.getHoraFin(),cli.getLocal(), cli.getDelivered(), cli.getPrepTime()));
        return 1;
    }

    public ArrayList<Pedido> selectAllPedidos() {
        return orders;
    }
  
}
