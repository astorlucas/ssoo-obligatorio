package com.ssoo.delidrones.negocio;

public class Reloj {
    private int counterDeliver;
    private int counterPrepare;
    private long allTimeDeliver;
    private long allTimePrepare;


    public long getallTimeDeliver() {
        return allTimeDeliver;
    }

    public long getallTimePrepare() {
        return allTimePrepare;
    }

    public Reloj() {
        this.counterDeliver = 0;
        this.counterPrepare = 0;
        this.allTimeDeliver = 0;
        this.allTimePrepare = 0;
    }

    public void addAllTimeDeliver(long total) {

        this.allTimeDeliver += total;
        this.counterDeliver++;
    }

    public void addAllTimePrepare(long total) {

        this.allTimePrepare += total;
        this.counterPrepare++;
    }

    public long promDeliver() {
        return (this.allTimeDeliver / this.counterDeliver );
    }

    public long promPrepare() {
        return (this.allTimePrepare / this.counterPrepare );
    }
}
