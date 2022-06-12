package com.ssoo.delidrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

import com.ssoo.delidrones.negocio.Dron;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.negocio.Reloj;
import com.ssoo.delidrones.procesos.*;
import com.ssoo.delidrones.utils.MyLog;
import com.ssoo.delidrones.utils.UtilsClass;


import com.ssoo.delidrones.negocio.Local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelidronesApplication {


	public static void main(String[] args) {

		SpringApplication.run(DelidronesApplication.class, args);
		Semaphore semDron = new Semaphore(1);
		Reloj metrics = new Reloj();
		Logger logger = Logger.getLogger("main");
		MyLog log2File = new MyLog();

		// Abrimos el local
		Local mainLocal = new Local(metrics, log2File);

		// Se cargan los drones
		for (int d = 1; d <= UtilsClass.ordersSize(); d++) {
			mainLocal.addDron(new Dron(d + "", Dron.DISPONIBLE, semDron));
		}

		// Se comienzan a recibir pedidos
		RecibirPedidos ourOrders = new RecibirPedidos();
		ourOrders.setTotal(UtilsClass.ordersSize());
		ourOrders.setLocal(mainLocal);

		UtilsClass.run(ourOrders);

		UtilsClass.run(mainLocal);
		
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Tiempo promedio de entrega de pedidos:" + String.valueOf(metrics.promDeliver() / 1000000));
		log2File.log("main", "Tiempo promedio de entrega de pedidos:", String.valueOf(metrics.promDeliver() / 1000000),".");
		logger.info("Tiempo promedio de preparación de pedidos:" + String.valueOf(metrics.promPrepare() / 1000000));
		log2File.log("main", "Tiempo promedio de preparación de pedidos:", String.valueOf(metrics.promPrepare() / 1000000), ".");

	}

}
