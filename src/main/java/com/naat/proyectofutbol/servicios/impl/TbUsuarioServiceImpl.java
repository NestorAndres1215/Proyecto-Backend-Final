package com.naat.proyectofutbol.servicios.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naat.proyectofutbol.entidades.TbUsuario;
import com.naat.proyectofutbol.modelo.TbLogin;
import com.naat.proyectofutbol.repositorios.TbUsuarioRepository;
import com.naat.proyectofutbol.repositorios.TbLoginRepository;
import com.naat.proyectofutbol.servicios.TbUsuarioService;

@Service
public class TbUsuarioServiceImpl implements TbUsuarioService {

	@Autowired
	private TbUsuarioRepository usuarioRepository;
	@Autowired
	private TbLoginRepository loginRepository;

	@Override
	public TbUsuario guardarUsuario(TbUsuario usuarios) {
		return usuarioRepository.save(usuarios);
	}

	@Override
	public TbLogin guardarlogin(TbLogin login) {
		return loginRepository.save(login);
	}

	@Override
	public List<Map<String, Object[]>> listarUsuario(int opcion, TbUsuario obj) {
		return usuarioRepository.ListaUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getUl_correo(), obj.getUl_telefono(),
				obj.getUl_direccion(), obj.getUl_rol());
	}

	@Override
	public String obtenerUltimoCodigoUsuario() {
		return usuarioRepository.obtenerUltimoCodigo();
	}

	@Override
	public void actualizarUsuario(int opcion, TbUsuario obj) {
		usuarioRepository.ActualizarUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getUl_correo(), obj.getUl_telefono(),
				obj.getUl_direccion(), obj.getUl_rol());

	}

	@Override
	public void eliminarUsuario(int opcion, TbUsuario obj) {
		usuarioRepository.EliminarUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getUl_correo(), obj.getUl_telefono(),
				obj.getUl_direccion(), obj.getUl_rol());
		
	}

}