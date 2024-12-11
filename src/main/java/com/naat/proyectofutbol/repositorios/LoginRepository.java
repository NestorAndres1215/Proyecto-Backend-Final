package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naat.proyectofutbol.modelo.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

	public Login findByUsername(String username);

}
