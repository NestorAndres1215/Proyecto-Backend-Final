package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naat.proyectofutbol.modelo.TbLogin;

public interface TbLoginRepository extends JpaRepository<TbLogin, Long> {

	public TbLogin findByUsername(String username);
	// List<UsuarioRol> findByRolRolNombre(String rolNombre);
	// List<UsuarioRol> findByRolRolNombreAndUsuarioEnabled(String rolNombre,
	// boolean enabled);
}
