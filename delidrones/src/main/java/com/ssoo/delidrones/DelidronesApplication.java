package com.ssoo.delidrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Semaphore;

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

		// Abrimos el local
		Local mainLocal = new Local();

		// Se cargan los drones
		for (int d = 1; d <= 12; d++) {
			mainLocal.addDron(new Dron(d + "", Dron.DISPONIBLE));
		}
		// Se comienzan a recibir pedidos
		RecibirPedidos ourOrders = new RecibirPedidos();
		ourOrders.setTotal(UtilsClass.ordersSize());
		ourOrders.setLocal(mainLocal);

		UtilsClass.run(ourOrders);
		UtilsClass.run(mainLocal);
	}

}
