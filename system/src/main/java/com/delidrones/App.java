package com.delidrones;

public class App 
{
    public static void main( String[] args )
    {   
        // int contador = 0;
        // for(int i = 0;i<7;i++){
        //     contador++;
        // }
        Local burger = new Local();
        Cliente pepito = new Cliente(burger);

        pepito.start();
        burger.start();
    }
}
