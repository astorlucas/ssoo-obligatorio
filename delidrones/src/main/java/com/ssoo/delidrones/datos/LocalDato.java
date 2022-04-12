package com.ssoo.delidrones.datos;

import java.util.ArrayList;
import java.util.UUID;

import com.ssoo.delidrones.negocio.Local;

import org.springframework.stereotype.Repository;

@Repository("local")
public class LocalDato {
    
    private static ArrayList<Local> lista = new ArrayList<>();

    public int insertLocal(Local local){
        UUID id = UUID.randomUUID();
        lista.add(new Local(id, local.getName(), local.getAdress(), local.isStation()));
        return 1;
    }

    public ArrayList<Local> selectAllLocals(){
        return lista;
    }
}
