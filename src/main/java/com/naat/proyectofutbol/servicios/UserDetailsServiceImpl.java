package com.naat.proyectofutbol.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.naat.proyectofutbol.modelo.Login;

import com.naat.proyectofutbol.repositorios.LoginRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private LoginRepository usuarioRepository;


	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Login usuario = this.usuarioRepository.findByUsername(username);
	        if(usuario == null){
	            throw new UsernameNotFoundException("Usuario no encontrado");
	        }
		return usuario;
	}


}
