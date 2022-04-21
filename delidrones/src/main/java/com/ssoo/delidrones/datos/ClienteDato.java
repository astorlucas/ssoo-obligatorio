package com.ssoo.delidrones.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import com.ssoo.delidrones.negocio.Cliente;

import org.springframework.stereotype.Repository;

@Repository("cliente")
public class ClienteDato implements Runnable {

    private static ArrayList<Cliente> lista = new ArrayList<>();

    public int insertCliente(Cliente cli) {
        UUID id = UUID.randomUUID();
        lista.add(new Cliente(id, cli.getName(), cli.getAdress(), cli.getOrder()));
        return 1;
    }

    public ArrayList<Cliente> selectAllClients() {
        return lista;
    }

    @Override
    public void run() {
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            File file = new File(
                    "C:/Sources/ssoo-obligatorio/delidrones/src/main/resources/cliente.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                UUID id = UUID.randomUUID();
                String[] employee = line.split(splitBy); // use comma as separator
                System.out.println("Name=" + employee[0] + ", Adress=" + employee[1]
                        + ", Order=" + employee[2]);
                lista.add(new Cliente(id,employee[0],employee[1],employee[2]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
