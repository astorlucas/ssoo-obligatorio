package com.ssoo.delidrones.datos;

import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Dron;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository("test")

public class DronDato {
    private static ArrayList<Dron> lista = new ArrayList<>();

    public int insertDron(Dron dron){
        UUID id = UUID.randomUUID();
        lista.add(new Dron(id));
        return 1;
    }

    public ArrayList<Dron> selectAllDrones(){
        return lista;
    }


}
