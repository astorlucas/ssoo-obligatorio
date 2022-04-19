package com.ssoo.delidrones;

import com.ssoo.delidrones.datos.ClienteDato;
import com.ssoo.delidrones.negocio.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelidronesApplication {

	public static void main(String[] args) {
		ClienteDato cli = new ClienteDato();
		Thread hilo = new Thread(cli,"hilo Update");
		hilo.start();
		
		SpringApplication.run(DelidronesApplication.class, args);

	}

}
