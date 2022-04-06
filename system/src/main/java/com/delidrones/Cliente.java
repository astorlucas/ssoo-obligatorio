package com.delidrones;

public class Cliente implements Runnable {

    public String name;
    public Pedido yourOrder;
    public String adress;
    //This is not ok, just for testing
    public Local local;
    private int tN;
    public Pedido ped;

    public Cliente(Pedido ped){
        this.ped = ped;
        Thread t = new Thread(this,"Cliente");
        t.start();
    }

    // public void createOrder(Local local) {

    //     for (int i = 0; i <= 5; i++) {
    //         System.out.println("Soy un pedido " + i);
    //     }
        

    // }

    @Override
    public void run() {
        
        int i=0;
        while(true){
            try {
                ped.request(i++);
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
