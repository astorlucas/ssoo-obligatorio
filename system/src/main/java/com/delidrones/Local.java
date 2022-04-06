package com.delidrones;

import java.util.ArrayList;

public class Local implements Runnable{

    public Boolean isStation;
    public ArrayList<Pedido> order;
    public String adress;
    //This is just for testing
    private int tN;
    public Pedido ped;

    public Local(Pedido ped){
        this.ped = ped;
        Thread t = new Thread(this,"Local");
        t.start();
    }

    // public void prepOrder(){
    //     for(int i = 0;i<4;i++){
    //         System.out.println("Estoy preparando el pedido "+i);
    //     }
        
    // }

    @Override
    public void run() {
        while(true){
            try {
                ped.deliver();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
