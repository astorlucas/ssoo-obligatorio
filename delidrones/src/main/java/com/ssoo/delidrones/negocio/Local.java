package com.ssoo.delidrones.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.logging.Logger;

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

    Logger logger =  Logger.getLogger(this.getClass().getName());
    private Queue<Dron> drones = new LinkedList<Dron>();
    private Queue<Pedido> pedidos = new LinkedList<Pedido>();
    private int pedidosIngresados = 0;
   

    public void changeState(Dron o, String s) {
        if (Dron.DISPONIBLE.equals(s)) {
            print("Dron " + o.id, s);

            this.drones.add(o);
        } else {
            if (Dron.PEDIDO_ENTREGADO.equals(s)) {
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                logger.info("Pedido: " + o.pedido.destiny + " entregado a las " + timeStamp);
                this.pedidosIngresados--;
            }

            print("Dron " + o.id, s + " pedido " + o.id + " order: " + o.pedido.getDestiny());
        }
    }

    public void changeState(Pedido o, String s) {
        if (Pedido.INGRESADO.equals(s)) {
            this.pedidosIngresados++;
        } else if (Pedido.PREPARADO.equals(s)) {
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            logger.info("El pedido: "+ o.destiny + " fue finalizado a las "+ timeStamp);
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
        logger.warning("# Inicia la jornada");

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

        logger.warning("# Finaliza la jornada");
    }

    private boolean procesarPedidos() {

        while (this.hasDronAndPedido()) {
            Dron dron = this.drones.poll();
            Pedido pedido = this.pedidos.poll();

            dron.setPedido(pedido);
            logger.info("THIS DRON: "+ dron.id + " has this order " + pedido.getDestiny());

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
        logger.info(String.format("%-10s - %-3s - %s", lbl, this.pedidosIngresados, msg));
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

}
