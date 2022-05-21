package com.ssoo.delidrones.procesos;

import com.ssoo.delidrones.negocio.Local;

public abstract class Watched implements Runnable {
    public final String id;

    public final String state;

    protected Local mainLocal;

    protected Watched(String id, String state) {
        super();
        this.id = id;
        this.state = state;
    }

    public void setLocal(Local thisLocal) {
        this.mainLocal = thisLocal;
    }
}
