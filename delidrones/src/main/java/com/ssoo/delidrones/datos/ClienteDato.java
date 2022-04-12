package com.ssoo.delidrones.datos;

import java.util.ArrayList;
import java.util.UUID;

import com.ssoo.delidrones.negocio.Cliente;

import org.springframework.stereotype.Repository;

@Repository("test")
public class ClienteDato {
    
    private static ArrayList<Cliente> lista = new ArrayList<>();

    public int insertCliente(Cliente cli){
        UUID id = UUID.randomUUID();
        lista.add(new Cliente(id, cli.getName(), cli.getAdress(), cli.getOrder()));
        return 1;
    }

    public ArrayList<Cliente> selectAllClients(){
        return lista;
    }

}
