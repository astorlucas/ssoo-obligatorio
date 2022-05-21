package com.ssoo.delidrones.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

@Repository("local")
public class LocalDato {

    private static ArrayList<Local> lista = new ArrayList<>();
    private static ArrayList<Local> stores = new ArrayList<>();
    public static List<Dron> drons = new CopyOnWriteArrayList<>();
    public static List<Pedido> pedidos = new CopyOnWriteArrayList<>();
    public static List<Pedido> cookedOrders = new CopyOnWriteArrayList<>();
    public static List<Thread> dronsThread = new CopyOnWriteArrayList<>();

    public static HashMap<String, String> pedidoYDron = new HashMap<>();

    // public int insertLocal(Local local) {
    //     UUID id = UUID.randomUUID();
    //     lista.add(new Local(id, local.getName(), local.getAdress(), local.isStation()));
    //     return 1;
    // }

    // public int insertPedido(Pedido cli) {
    //     UUID id = UUID.randomUUID();
    //     pedidos.add(new Pedido(id, cli.getfoodName(), cli.getDestino(), cli.getDistancia(), cli.getOrigen(),
    //             cli.getHoraFin(), cli.getLocal(), cli.getDelivered(), cli.getPrepTime()));
    //     return 1;
    // }

    // public int insertDron(Dron cli) {
    //     UUID id = UUID.randomUUID();
    //     drons.add(new Dron(this));
    //     return 1;
    // }

    // public ArrayList<Local> selectAllLocals() {
    //     return lista;
    // }

   
    // public void cargarDrones() {
    //     String line = "";
    //     String splitBy = ",";
    //     try {

    //         File file = new File(
    //                 "./src/main/resources/dron.csv");
    //         FileReader fr = new FileReader(file);
    //         BufferedReader br = new BufferedReader(fr);
    //         while ((line = br.readLine()) != null) {
    //             UUID id = UUID.randomUUID();
    //             String[] linea = line.split(splitBy);
    //             Double bat = Double.parseDouble(linea[1]);
    //             drons.add(new Dron(id, linea[0], bat, false));

    //         }
    //         br.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    // }

    // public void cargarPedidos() {
    //     String line = "";
    //     String splitBy = ",";
    //     try {
    //         File file = new File(
    //                 "./src/main/resources/pedido.csv");
    //         FileReader fr = new FileReader(file);
    //         BufferedReader br = new BufferedReader(fr);
    //         while ((line = br.readLine()) != null) {
    //             UUID id = UUID.randomUUID();
    //             String[] linea = line.split(splitBy);
    //             Integer dist = Integer.parseInt(linea[2]);
    //             Integer prepTime = Integer.parseInt(linea[7]);
    //             boolean delivered = Boolean.parseBoolean(linea[6]);
    //             pedidos.add(
    //                     new Pedido(id, linea[0], linea[1], dist, linea[3], linea[4], linea[5], delivered, prepTime));
    //         }
    //         br.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    // }


    // public List<Pedido> selectAllPedidos() {
    //     return pedidos;
    // }

    // public List<Dron> selectAllDrones() {
    //     return drons;
    // }

}
