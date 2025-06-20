package com.aluraCursos.proyecto1_API.librosAPI;

import com.aluraCursos.proyecto1_API.librosAPI.Principal.Principal;
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
		//System.out.println("Hello world");	//Only test
		//Principal object
		Principal principal = new Principal();

		//Call the method informationBooks of Principal class
		principal.informationBooks();
	}
}
