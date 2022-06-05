package com.ssoo.delidrones.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.procesos.RecibirPedidos;
import com.ssoo.delidrones.procesos.Watched;
import com.ssoo.delidrones.utils.UtilsClass;

import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.joran.action.ReceiverAction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository("mainLocal")
public class Local implements Runnable {

    private Queue<Dron> drones = new LinkedList<Dron>();
    private Queue<Pedido> pedidos = new LinkedList<Pedido>();
    private int pedidosIngresados = 0;
    private FileWriter myWriter;

    public FileWriter getMyWriter() {
        return myWriter;
    }

    public static void setMyWriter(FileWriter myWriter) {
        try {
            myWriter = new FileWriter("./src/main/resources/newPedido.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeState(Dron o, String s) {
        if (Dron.DISPONIBLE.equals(s)) {
            print("Dron " + o.id, s);

            this.drones.add(o);
        } else {
            if (Dron.PEDIDO_ENTREGADO.equals(s)) {
                this.pedidosIngresados--;
            }

            print("Dron " + o.id, s + " pedido " + o.pedido.id + " time: " + o.pedido.getPrepTime());
        }
    }

    public void changeState(Pedido o, String s) {
        if (Pedido.INGRESADO.equals(s)) {
            this.pedidosIngresados++;
        } else if (Pedido.PREPARADO.equals(s)) {
            this.pedidos.add(o);
        }

    }

    public void addDron(Dron dron) {
        dron.setLocal(this);
    }

    public void addPedido(Pedido pedido) {
        pedido.setLocal(this);
    }

    public void run() {
        System.out.println("# Inicia la jornada");

        while (!this.hasPedidosIngresados()) {
            UtilsClass.sleep(2);
        }

        while (this.hasPedidosIngresados() || this.hasPedidos()) {

            UtilsClass.sleep(5);

            this.procesarPedidos();

        }

        while (this.hasPedidosIngresados()) {
            UtilsClass.sleep(2);
        }

        System.out.println("# Finaliza la jornada");
    }

    private boolean procesarPedidos() {

        while (this.hasDronAndPedido()) {
            Dron dron = this.drones.poll();
            Pedido pedido = this.pedidos.poll();

            dron.setPedido(pedido);

            UtilsClass.run(dron);
        }

        return true;
    }

    public boolean hasDronAndPedido() {
        return this.hasDrones() && this.hasPedidos();
    }

    public boolean hasDrones() {
        return !this.drones.isEmpty();
    }

    public boolean hasPedidos() {
        return !this.pedidos.isEmpty();
    }

    public boolean hasPedidosIngresados() {
        return this.pedidosIngresados > 0;
    }

    public void print(String lbl, String msg) {
        System.out.println(String.format("%-10s - %-3s - %s", lbl, this.pedidosIngresados, msg));
    }

    public Queue<Dron> getDrones() {
        return drones;
    }

    public void setDrones(Queue<Dron> drones) {
        this.drones = drones;
    }

    public Queue<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Queue<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // public int insertPedido(Pedido pedido) {
    //     try {
    //         String line = pedido.id + "," + pedido.state + "," + pedido.prepTime + "," + pedido.distance;
    //         myWriter.write(line);
    //         if (line.contains("close")) {
    //             myWriter.close();
    //         }
    //     } catch (IOException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    //     return 1;
    // }

}
