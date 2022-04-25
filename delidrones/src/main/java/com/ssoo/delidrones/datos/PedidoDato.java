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
        orders.add(new Pedido(id, cli.getId_cliente(), cli.getDestino(), cli.getDistancia(), cli.getOrigen(),
                cli.getHoraFin(),cli.getLocal(), cli.getDelivered()));
        return 1;
    }

    public ArrayList<Pedido> selectAllPedidos() {
        return orders;
    }

    //this just for test
    // public void cargarPedidos() { // o run() si es un thread
    //     String line = "";
    //     String splitBy = ",";
    //     try {
    //         // parsing a CSV file into BufferedReader class constructor
    //         File file = new File(
    //                 "C:/Sources/ssoo-obligatorio/delidrones/src/main/resources/pedido.csv");
    //         FileReader fr = new FileReader(file);
    //         BufferedReader br = new BufferedReader(fr);
    //         while ((line = br.readLine()) != null) // returns a Boolean value
    //         {
    //             UUID id = UUID.randomUUID();
    //             String[] linea = line.split(splitBy); // use comma as separator
    //             System.out.println("ID CLIENTE=" + linea[0] + ", Adress=" + linea[1]
    //                     + ", Distancia=" + linea[2] + ", Local=" + linea[5]);
    //             Integer dist = Integer.parseInt(linea[2]);
    //             Integer idCli = Integer.parseInt(linea[2]);
    //             orders.add(new Pedido(id,idCli,linea[1],dist,linea[3],linea[4],linea[5]));
    //         }
    //         br.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    // }

  
}
