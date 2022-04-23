package com.ssoo.delidrones;

import java.util.Arrays;

import com.ssoo.delidrones.datos.ClienteDato;
import com.ssoo.delidrones.datos.DronDato;
import com.ssoo.delidrones.datos.LocalDato;
import com.ssoo.delidrones.datos.PedidoDato;
import com.ssoo.delidrones.negocio.Cliente;
import com.ssoo.delidrones.negocio.Pedido;
import com.ssoo.delidrones.negocio.Local;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelidronesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DelidronesApplication.class, args);

		ClienteDato cli = new ClienteDato();
		Thread hilo = new Thread(cli,"hilo Update");
		hilo.start();
		LocalDato mainLocal = new LocalDato();
		mainLocal.cargarLocales();
		PedidoDato mainPedido = new PedidoDato();
		mainPedido.cargarPedidos();
		mainLocal.cargarDrones();

		//mainLocal.procesarPedidos();

		Local illMondo = mainLocal.selectThatLocal("illmondodelapizza");
		Local laPasiva = mainLocal.selectThatLocal("lapasiva");
		System.out.println("Drones ill: "+ illMondo.drones.toString());
		System.out.println("Drones lapa: "+ laPasiva.drones.toString());
		

		
	}

}
