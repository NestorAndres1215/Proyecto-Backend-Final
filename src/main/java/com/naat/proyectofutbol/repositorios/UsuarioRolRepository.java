package com.naat.proyectofutbol.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naat.proyectofutbol.modelo.UsuarioRol;



public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
	//List<UsuarioRol> findByRolRolNombre(String rolNombre);
	List<UsuarioRol> findByRolRolNombreAndUsuarioEnabled(String rolNombre, boolean enabled);
}
