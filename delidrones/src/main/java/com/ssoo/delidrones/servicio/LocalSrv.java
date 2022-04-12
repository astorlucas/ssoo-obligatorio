package com.ssoo.delidrones.servicio;

import com.ssoo.delidrones.datos.LocalDato;

import org.springframework.stereotype.Service;

@Service
public class LocalSrv {
    private final LocalDato localDato;

    public LocalSrv(LocalDato localDato) {
        this.localDato = localDato;
    }
    
}
