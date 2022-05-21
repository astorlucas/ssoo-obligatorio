package com.ssoo.delidrones;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Semaphore;

import com.ssoo.delidrones.datos.DronDato;
import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.datos.PedidoDato;
import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.procesos.*;
import com.ssoo.delidrones.utils.UtilsClass;
import com.ssoo.delidrones.negocio.Local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelidronesApplication {

	public static void main(String[] args) {

		SpringApplication.run(DelidronesApplication.class, args);
		// Semaphore semDron = new Semaphore(0);

		// // Abren los locales
		// LocalDato mainLocal = new LocalDato();
		// // mainLocal.cargarLocales();
		// mainLocal.cargarPedidos();
		// mainLocal.cargarDrones();

		// // Se comienzan a cocinar los pedidos crudos
		// Thread cocinar = new Thread(new PrepararOrden(mainLocal, semDron));
		// cocinar.start();
		// // Se reparten pedidos cocinados a demanda
		// Thread repartidorHilo1 = new Thread(new RepartirPedidos(semDron, mainLocal));
		// repartidorHilo1.start();

		
		//Abrimos el local
		Local mainLocal = new Local();

		//Se cargan los drones
		for (int d = 1; d <= 10; d++) {
			mainLocal.addDron(new Dron(d + "", Dron.DISPONIBLE));
		}

		//Se comienzan a recibir pedidos
		RecibirPedidos ourOrders = new RecibirPedidos(5, mainLocal);

		UtilsClass.run(ourOrders);
		UtilsClass.run(mainLocal);

	}

}
