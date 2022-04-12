package com.ssoo.delidrones.servicio;

import java.util.ArrayList;

import com.ssoo.delidrones.datos.ClienteDato;
import com.ssoo.delidrones.negocio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClienteSrv {
    
    private final ClienteDato clienteDato;

    @Autowired
    public ClienteSrv(@Qualifier("test") ClienteDato cli){
        this.clienteDato = cli;
    }

    public int addClient(Cliente cliente){
        return clienteDato.insertCliente(cliente);
    }

    public ArrayList<Cliente> getAllClients(){
        return clienteDato.selectAllClients();
    }

}
