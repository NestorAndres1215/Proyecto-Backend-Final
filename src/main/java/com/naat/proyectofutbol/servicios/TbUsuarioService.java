package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.TbUsuario;

import com.naat.proyectofutbol.modelo.TbLogin;

public interface TbUsuarioService {

	public TbUsuario guardarUsuario(TbUsuario usuarios);

	public TbLogin guardarlogin(TbLogin login);

	public List<Map<String, Object[]>> listarUsuario(int opcion, TbUsuario obj);

	void actualizarUsuario(int opcion, TbUsuario obj);
	
	void eliminarUsuario(int opcion, TbUsuario obj);

	public String obtenerUltimoCodigoUsuario();

}
