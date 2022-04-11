package com.ssoo.delidrones.datos;

import java.util.ArrayList;

import com.ssoo.delidrones.negocio.Cliente;

import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.util.ArrayUtils;

@Repository("test")
public class ClienteDato {
    
    static ArrayList lista = new ArrayList<>();

    public int insertCliente(Cliente cli){
        lista.add(cli.getName());
        return 1;
    }
}
