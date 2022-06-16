package com.ssoo.delidrones.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssoo.delidrones.procesos.Watched;
import com.ssoo.delidrones.utils.UtilsClass;

import lombok.*;

import java.util.UUID;
import java.util.concurrent.Semaphore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dron extends Watched {

    public static final String DISPONIBLE = "disponible";
    public static final String HACIA_EL_RESTAURANT = "hacia-restaurant";
    public static final String HACIA_EL_DESTINO = "hacia-destinatario";
    public static final String PEDIDO_ENTREGADO = "pedido-entregado";
    private Semaphore semaforo;

    public Pedido pedido;

    public Dron(String id, String state, Semaphore sem) {
        super(id, state);
        this.semaforo = sem;
    }

    @Override
    public void setLocal(Local thisLocal) {
        super.setLocal(thisLocal);

        this.mainLocal.changeState(this, Dron.DISPONIBLE);
    }

    public void run() {

        this.mainLocal.changeState(this, HACIA_EL_RESTAURANT);

        UtilsClass.sleepRand(1, 3);

        this.mainLocal.changeState(this, HACIA_EL_DESTINO);

        UtilsClass.sleepRand(1, 3);

        this.mainLocal.changeState(this, PEDIDO_ENTREGADO);

        this.pedido = null;
        semaforo.release();
        this.mainLocal.changeState(this, DISPONIBLE);

    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void assignOrder(Pedido pedido){
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setPedido(pedido);

    }

}
