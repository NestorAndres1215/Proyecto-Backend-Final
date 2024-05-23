package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naat.proyectofutbol.modelo.TbLogin;

public interface TbLoginRepository extends JpaRepository<TbLogin, String> {

	public TbLogin findByUsername(String username);

}
