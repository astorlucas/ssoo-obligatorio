package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository("pedido")

public class PedidoDato {

    private static ArrayList<Pedido> lista = new ArrayList<>();

    public int insertPedido(Pedido cli) {
        UUID id = UUID.randomUUID();
        lista.add(new Pedido(id, cli.getId_cliente(), cli.getTiempoEnvio(), cli.getDistancia(), cli.getHoraInicio(),
                cli.getHoraFin()));
        return 1;
    }

    public ArrayList<Pedido> selectAllPedidos() {
        return lista;
    }
}
