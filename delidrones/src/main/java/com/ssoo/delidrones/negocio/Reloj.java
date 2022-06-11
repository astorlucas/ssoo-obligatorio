package com.ssoo.delidrones.negocio;

import java.util.concurrent.Semaphore;

public class Reloj {
    private int counter;
    private long allTime;

    public void setContador(int contador) {
        this.counter = contador;
    }

    public long getallTime() {
        return allTime;
    }

    public int getCounter() {
        return counter;
    }

    public Reloj() {
        this.counter = 0;
        this.allTime = 0;
    }

    public void addAllTime(long n) {

        this.allTime += n;
        this.counter++;
    }

    public long prom() {
        return (this.allTime / this.counter );
    }
}
