package com.delidrones;

public class App 
{
    public static void main( String[] args )
    {   
        Pedido p1 = new Pedido();
        
        new Local(p1);
        new Cliente(p1);
        
    }
}
