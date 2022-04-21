package com.ssoo.delidrones.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

@Repository("local")
public class LocalDato {

    private static ArrayList<Local> lista = new ArrayList<>();
    private static ArrayList<Local> stores = new ArrayList<>();
    private static ArrayList<Dron> drons = new ArrayList<>();
    public static ArrayList<Pedido> pedidos = PedidoDato.orders;
    //public static HashMap<Pedido,Dron> pedidoYDron = new HashMap<>(); this is how it is supposed to be
    public static HashMap<String,String> pedidoYDron = new HashMap<>();

    public int insertLocal(Local local) {
        UUID id = UUID.randomUUID();
        lista.add(new Local(id, local.getName(), local.getAdress(), local.isStation()));
        return 1;
    }

    public ArrayList<Local> selectAllLocals() {
        return lista;
    }

    public void cargarLocales() { // o run() si es un thread
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            File file = new File(
                    "C:/Sources/ssoo-obligatorio/delidrones/src/main/resources/local.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                UUID id = UUID.randomUUID();
                String[] linea = line.split(splitBy); // use comma as separator
                System.out.println("Name=" + linea[0] + ", Adress=" + linea[1]
                        + ", Order=" + linea[2]);
                boolean isStation = Boolean.parseBoolean(linea[2]);
                stores.add(new Local(id, linea[0], linea[1], isStation));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDrones() { // o run() si es un thread
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            File file = new File(
                    "C:/Sources/ssoo-obligatorio/delidrones/src/main/resources/dron.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                UUID id = UUID.randomUUID();
                String[] linea = line.split(splitBy); // use comma as separator
                Double bat = Double.parseDouble(linea[1]);
                System.out.println("Dueño DRON=" + linea[0] + ", Battery=" + bat);

                drons.add(new Dron(id, linea[0], bat));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void procesarPedidos(){
        for(Pedido p : pedidos){
            for(Dron d : drons){
                pedidoYDron.put(p.getOrigen(), d.getBateria().toString());
            }
        }
    }

}
