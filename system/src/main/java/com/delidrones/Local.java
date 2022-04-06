package com.delidrones;

import java.util.ArrayList;

public class Local extends Thread{

    public Boolean isStation;
    public ArrayList<Pedido> order;
    public String adress;
    //This is just for testing
    private int tN;

    // public Local(int tN){
    //     this.tN = tN;
    // }

    public void prepOrder(){
        for(int i = 0;i<4;i++){
            System.out.println("Estoy preparando el pedido "+i);
        }
        
    }

    @Override
    public void run() {
        prepOrder();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
