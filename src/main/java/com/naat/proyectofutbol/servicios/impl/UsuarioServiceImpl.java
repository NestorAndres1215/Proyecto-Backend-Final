package com.naat.proyectofutbol.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naat.proyectofutbol.entidades.TbUsuario;

import com.naat.proyectofutbol.modelo.TbLogin;

import com.naat.proyectofutbol.repositorios.UsuarioRepository;
import com.naat.proyectofutbol.repositorios.LoginRepository;
import com.naat.proyectofutbol.servicios.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LoginRepository loginRepository; // Añade esta línea
    
	@Override
	public TbUsuario guardarUsuario(TbUsuario usuarios) {
	
		return usuarioRepository.save(usuarios);
	}

	@Override
	public TbLogin guardarlogin(TbLogin login) {
	
		return loginRepository.save(login);
	}


	
}