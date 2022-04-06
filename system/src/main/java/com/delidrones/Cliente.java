package com.delidrones;

public class Cliente extends Thread {

    public String name;
    public Pedido yourOrder;
    public String adress;
    //This is not ok, just for testing
    public Local local;
    private int tN;

    public Cliente(Local local){
        this.local = local;
        this.tN = tN;
    }

    public void createOrder(Local local) {

        for (int i = 0; i <= 5; i++) {
            System.out.println("Soy un pedido " + i);
        }
        

    }

    @Override
    public void run() {
        
        createOrder(local);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
