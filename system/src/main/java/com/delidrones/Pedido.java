package com.delidrones;

import java.sql.Date;

public class Pedido {

    public Integer quantity;
    public String adress;
    public Date date;
    public boolean valueSet = false;

    public synchronized void request(int q) throws InterruptedException{
        while(valueSet){
            wait();
        }
        System.out.println("Request "+quantity);
        this.quantity = q;
        valueSet = true;
        notify();
    }

    public synchronized void deliver() throws InterruptedException{
        while(!valueSet){
            wait();
        }
        System.out.println("Deliver "+quantity);
        valueSet = false;
        notify();
        //notifica
    }


}
