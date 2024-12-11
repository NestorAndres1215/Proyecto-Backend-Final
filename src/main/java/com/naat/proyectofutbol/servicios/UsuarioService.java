package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.Usuario;

import com.naat.proyectofutbol.modelo.Login;

public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuarios);

	boolean usuarioExistePorUsername(String username);

	boolean usuarioExistePorEmail(String email);
	boolean existsByUsernameAndPassword(String username, String password);

	boolean usuarioExistePorTelefono(String telefono);
	
	boolean telefonoEsValido(String telefono);

	public Usuario guardarImagen(String ul_codigo, MultipartFile archivo) throws IOException;

	public Login guardarlogin(Login login);

	public List<Map<String, Object[]>> listarUsuario(int opcion, Usuario obj);

	String actualizarUsuario(int opcion, Usuario obj);

	void eliminarUsuario(int opcion, Usuario obj);

	void delete(String codigo);

	public String obtenerUltimoCodigoUsuario();

	public List<Map<String, Object[]>> listarPorCodigo(int opcion, Usuario obj);

	public List<Map<String, Object[]>> ListarPorRol(int opcion, Usuario obj);
	public List<Map<String, Object[]>> ListarPorUsuario(int opcion, Usuario obj);
}
