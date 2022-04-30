package com.ssoo.delidrones.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Local;
import com.ssoo.delidrones.negocio.Pedido;

import org.springframework.stereotype.Repository;

@Repository("local")
public class LocalDato implements Runnable {

    private static ArrayList<Local> lista = new ArrayList<>();
    private static ArrayList<Local> stores = new ArrayList<>();
    public static List<Dron> drons = new CopyOnWriteArrayList<>();
    public static List<Pedido> pedidos = new CopyOnWriteArrayList<>();
    // public static HashMap<Pedido,Dron> pedidoYDron = new HashMap<>(); this is how
    // it is supposed to be
    public static HashMap<String, String> pedidoYDron = new HashMap<>();

    public int insertLocal(Local local) {
        UUID id = UUID.randomUUID();
        lista.add(new Local(id, local.getName(), local.getAdress(), local.isStation()));
        return 1;
    }

    // Esto es para probar añadiendo directamente en la lista que a mi me interesa
    // ir recorriendo.
    public int insertDron(Dron dron) {
        UUID id = UUID.randomUUID();
        drons.add(new Dron(id, dron.getDueno(), dron.getBateria(), dron.getAva()));
        return 1;
    }

    public int insertPedido(Pedido cli) {
        UUID id = UUID.randomUUID();
        pedidos.add(new Pedido(id, cli.getId_cliente(), cli.getDestino(), cli.getDistancia(), cli.getOrigen(),
                cli.getHoraFin(), cli.getLocal(), cli.getDelivered()));
        return 1;
    }

    // Esto es para probar añadiendo directamente en la lista que a mi me interesa
    // ir recorriendo.

    public ArrayList<Local> selectAllLocals() {
        return lista;
    }

    public static Local selectThatLocal(String name) {
        for (Local l : stores) {
            if (name.equals(l.getName())) {
                return l;
            }
            continue;
        }
        return null;

    }

    public void cargarLocales() { // o run() si es un thread
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            File file = new File(
                    "./src/main/resources/local.csv");
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
                    "./src/main/resources/dron.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                UUID id = UUID.randomUUID();
                String[] linea = line.split(splitBy); // use comma as separator
                Double bat = Double.parseDouble(linea[1]);
                //boolean busy = Boolean.parseBoolean(linea[2]);
                System.out.println("Dueño DRON=" + linea[0] + ", Battery=" + bat + " Busy: " + linea[1]);
                // Local thisLocal = selectThatLocal(linea[0]);
                // System.out.println(thisLocal.getName());
                // if (thisLocal != null && thisLocal.getName().equals(linea[0])) {
                // thisLocal.drones.add(new Dron(id, linea[0], bat));
                // }
                
                drons.add(new Dron(id, linea[0], bat, true));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cargarPedidos() { // o run() si es un thread
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            File file = new File(
                    "./src/main/resources/pedido.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                UUID id = UUID.randomUUID();
                String[] linea = line.split(splitBy); // use comma as separator
                System.out.println("ID CLIENTE=" + linea[0] + ", Adress=" + linea[1]
                        + ", Distancia=" + linea[2] + ", Local=" + linea[5]);
                Integer dist = Integer.parseInt(linea[2]);
                Integer idCli = Integer.parseInt(linea[2]);
                boolean delivered = Boolean.parseBoolean(linea[6]);
                pedidos.add(new Pedido(id, idCli, linea[1], dist, linea[3], linea[4], linea[5], delivered));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Dron> dronesDeLocal(String name) {
        Local thisLocal = selectThatLocal(name);
        return thisLocal.drones;
    }

    public void procesarPedidos() {
        for (Pedido p : pedidos) {
            for (Dron d : drons) {
                pedidoYDron.put(p.getOrigen(), d.getBateria().toString());
            }
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    public List<Pedido> selectAllPedidos() {
        return pedidos;
    }

    public List<Dron> selectAllDrones() {
        return drons;
    }

}
