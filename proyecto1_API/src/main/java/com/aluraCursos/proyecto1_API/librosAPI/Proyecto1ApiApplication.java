package com.aluraCursos.proyecto1_API.librosAPI;

import Principal.Principal;
import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proyecto1ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1ApiApplication.class, args);
	}

	//CommandLineRunner run method
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Hello world");
		//Principal object
		Principal principal = new Principal();

		//Call the method informationBooks of Principal class
		principal.informationBooks();
	}
}
