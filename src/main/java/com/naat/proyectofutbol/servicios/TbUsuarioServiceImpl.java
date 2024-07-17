package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getTelefono(), obj.getUl_direccion(),
				obj.getUl_rol());
	}

	@Override
	public String obtenerUltimoCodigoUsuario() {
		return usuarioRepository.obtenerUltimoCodigo();
	}

	@Override
	public void actualizarUsuario(int opcion, TbUsuario obj) {
		usuarioRepository.ActualizarUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getUl_direccion(), obj.getTelefono(),
				obj.getUl_rol());

	}

	@Override
	public void eliminarUsuario(int opcion, TbUsuario obj) {
		usuarioRepository.EliminarUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getTelefono(), obj.getUl_direccion(),
				obj.getUl_rol());

	}

	@Override
	public void delete(String codigo) {
		loginRepository.deleteById(codigo);

	}

	@Override
	public List<Map<String, Object[]>> listarPorCodigo(int opcion, TbUsuario obj) {
		return usuarioRepository.ListarPorCodigo(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getTelefono(), obj.getUl_direccion(),
				obj.getUl_rol());
	}

	@Override
	public List<Map<String, Object[]>> ListarPorRol(int opcion, TbUsuario obj) {
		return usuarioRepository.ListarPorRol(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getTelefono(), obj.getUl_direccion(),
				obj.getUl_rol());
	}

	@Override
	public TbUsuario guardarImagen(String ul_codigo, MultipartFile archivo) throws IOException {
		Optional<TbUsuario> usuarioOptional = usuarioRepository.findById(ul_codigo);
		TbUsuario usuario;
		if (usuarioOptional.isPresent()) {
			usuario = usuarioOptional.get();
		} else {
			usuario = new TbUsuario();
			usuario.setUl_codigo(ul_codigo);
		}
		usuario.setUl_perfil(archivo.getBytes());
		return usuarioRepository.save(usuario);
	}

	public boolean usuarioExistePorUsername(String username) {
		return usuarioRepository.existsByUsername(username);
	}

	public boolean usuarioExistePorEmail(String email) {
		return usuarioRepository.existsByCorreo(email);
	}

	@Override
	public boolean existsByUsernameAndPassword(String username, String password) {
		return usuarioRepository.existsByUsernameAndPassword(username,password);
	}

	public boolean usuarioExistePorTelefono(String telefono) {
		return usuarioRepository.existsByTelefono(telefono);
	}

	public boolean telefonoEsValido(String telefono) {
		return telefono.matches("\\d{9}");
	}

	@Override
	public List<Map<String, Object[]>> ListarPorUsuario(int opcion, TbUsuario obj) {
		return usuarioRepository.ListarPorUsuario(opcion, obj.getUl_codigo(), obj.getUsername(), obj.getPassword(),
				obj.getUl_nombre(), obj.getUl_apellido(), obj.getCorreo(), obj.getTelefono(), obj.getUl_direccion(),
				obj.getUl_rol());
	}

}