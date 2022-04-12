package com.ssoo.delidrones.servicio;

import java.util.ArrayList;

import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.negocio.Local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LocalSrv {
    private final LocalDato localDato;

    @Autowired
    public LocalSrv(@Qualifier("local") LocalDato localDato) {
        this.localDato = localDato;
    }

    public int addLocal(Local local){
        return localDato.insertLocal(local);
    }

    public ArrayList<Local> getAllLocals(){
        return localDato.selectAllLocals();
    }

    
}
