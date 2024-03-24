package com.naat.proyectofutbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.naat.proyectofutbol.servicios.UsuarioService;


@SpringBootApplication
public class ProyectoFutbolApplication implements CommandLineRunner{
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFutbolApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
			
	}

}
