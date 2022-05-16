package com.ssoo.delidrones;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

import com.ssoo.delidrones.datos.ClienteDato;
import com.ssoo.delidrones.datos.DronDato;
import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.datos.PedidoDato;
import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.procesos.*;
import com.ssoo.delidrones.negocio.Local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelidronesApplication {

	public static void main(String[] args) {

		SpringApplication.run(DelidronesApplication.class, args);

		//Abren los locales
		Local laPasiva = new Local(null, "la_Pasiva", "18_de_Julio_1123", true);
		Local illMondo = new Local(null, "ill_Mondo", "18_de_Julio_1255", true);
		LocalDato mainLocal = new LocalDato();
		mainLocal.cargarLocales();
		mainLocal.cargarPedidos();
		mainLocal.cargarDrones();

		// Integer cantDrones = mainLocal.dronsThread.size();
		// Semaphore semDron = new Semaphore(cantDrones);

		//Se comienzan a cocinar los pedidos crudos
		Thread cocinar = new Thread(new PrepararOrden(mainLocal));
		cocinar.start();

		//Se encienden los drones para que empiecen a repartir pedidos listos
		for(Thread work : mainLocal.dronsThread){
			work.start();
		}

		// Thread miHilo = new Thread(new EntregarPedidos(mainLocal));
		// miHilo.start();

		// mainLocal.procesarPedidos();

		// Local illMondo = mainLocal.selectThatLocal("illmondodelapizza");
		// Local laPasiva = mainLocal.selectThatLocal("lapasiva");
		// System.out.println("Drones ill: "+ illMondo.drones.toString());
		// System.out.println("Drones lapa: "+ laPasiva.drones.toString());

	}

}
