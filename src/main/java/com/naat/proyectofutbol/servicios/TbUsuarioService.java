package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbUsuario;

import com.naat.proyectofutbol.modelo.TbLogin;

public interface TbUsuarioService {

	public TbUsuario  guardarUsuario(TbUsuario usuarios);

	boolean usuarioExistePorUsername(String username);

	boolean usuarioExistePorEmail(String email);

	boolean usuarioExistePorTelefono(String telefono);
	
	boolean telefonoEsValido(String telefono);

	public TbUsuario guardarImagen(String ul_codigo, MultipartFile archivo) throws IOException;

	public TbLogin guardarlogin(TbLogin login);

	public List<Map<String, Object[]>> listarUsuario(int opcion, TbUsuario obj);

	void actualizarUsuario(int opcion, TbUsuario obj);

	void eliminarUsuario(int opcion, TbUsuario obj);

	void delete(String codigo);

	public String obtenerUltimoCodigoUsuario();

	public List<Map<String, Object[]>> listarPorCodigo(int opcion, TbUsuario obj);

	public List<Map<String, Object[]>> ListarPorRol(int opcion, TbUsuario obj);
}
