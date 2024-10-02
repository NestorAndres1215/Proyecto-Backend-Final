package com.naat.proyectofutbol.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naat.proyectofutbol.constrainst.Mensaje;
import com.naat.proyectofutbol.constrainst.UsuarioError;
import com.naat.proyectofutbol.response.UsuarioLoginResponse;
import com.naat.proyectofutbol.util.Utilitarios;
import org.slf4j.helpers.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.Usuario;
import com.naat.proyectofutbol.modelo.Login;
import com.naat.proyectofutbol.servicios.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/")
	public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		String ultimoCodigoUsuario = usuarioService.obtenerUltimoCodigoUsuario();


		String nuevoCodigoUsuario= Utilitarios.incrementarSecuencia(ultimoCodigoUsuario);
		usuario.setUl_codigo(nuevoCodigoUsuario);
		Login user = new Login();
		user.setUs_codigo(nuevoCodigoUsuario);
		user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		user.setUsername(usuario.getUsername());
		user.setUs_rol(usuario.getUl_rol());

		try {

			if (usuarioService.usuarioExistePorUsername(usuario.getUsername())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.USUARIO_EXISTENTE.getMensaje());
			}
			if (usuarioService.usuarioExistePorEmail(usuario.getCorreo())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.CORREO_EXISTENTE.getMensaje());
			}
			if (usuarioService.usuarioExistePorTelefono(usuario.getTelefono())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.TELEFONO_EXISTENTE.getMensaje());
			}
			if (!usuarioService.telefonoEsValido(usuario.getTelefono())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.TELEFONO_DIGITOS.getMensaje());
			}

			 usuarioService.guardarlogin(user);
			 usuarioService.guardarUsuario(usuario);

			UsuarioLoginResponse response = new UsuarioLoginResponse(usuario, user);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}
	}

	@GetMapping(value = { "/listaUsuario/" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaUsuario() throws Exception {
		List<Map<String, Object[]>> lista;
		Usuario obj = new Usuario();

		try {

			lista = usuarioService.listarUsuario(0, obj);

			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@PutMapping("/actualizarUsuario/")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {

				Login user = new Login();
				user.setUs_codigo(usuario.getUl_codigo());
				user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
				user.setUsername(usuario.getUsername());
				user.setUs_rol(usuario.getUl_rol());
		try {

			if (!usuarioService.telefonoEsValido(usuario.getTelefono())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.TELEFONO_DIGITOS.getMensaje());
			}

			usuarioService.guardarlogin(user);

			usuarioService.actualizarUsuario(1, usuario);


			UsuarioLoginResponse response = new UsuarioLoginResponse(usuario, user);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// Maneja cualquier excepción que ocurra durante el proceso
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al actualizar el usuario.");
		}


	}

	@DeleteMapping("/eliminarUsuario/{codigo}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable("codigo") String codigo) {
		Map<String, Object> salida = new HashMap<>();
		Usuario obj = new Usuario(codigo, "", "", "", "", "", "", "", "", "", false);

		try {
			usuarioService.eliminarUsuario(2, obj);
			usuarioService.delete(codigo);
			salida.put("mensaje", "Usuario eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al eliminar usuario: " + e.getMessage());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping(value = { "/listaUsuario/{codigo}" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaPorCodigo(@PathVariable("codigo") String codigo)
			throws Exception {
		List<Map<String, Object[]>> lista;
		Usuario obj = new Usuario();

		obj.setUl_codigo(codigo);
		try {
			lista = usuarioService.listarPorCodigo(3, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@GetMapping(value = { "/listaUsuario/rol/{rol}" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaPorRol(@PathVariable("rol") String rol) throws Exception {
		List<Map<String, Object[]>> lista;
		Usuario obj = new Usuario();

		obj.setUl_rol(rol);
		try {
			lista = usuarioService.ListarPorRol(4, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@PostMapping("/upload/{ul_codigo}")
	public ResponseEntity<String> subirImagen(@PathVariable String ul_codigo,
			@RequestParam("archivo") MultipartFile archivo) {
		try {
			usuarioService.guardarImagen(ul_codigo, archivo);
			return new ResponseEntity<>("Imagen subida correctamente", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("Error subiendo la imagen", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = { "/listaUsuario/usuario/{usuario}" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaPorUsuario(@PathVariable("usuario") String usuario)
			throws Exception {
		List<Map<String, Object[]>> lista;
		Usuario obj = new Usuario();


		obj.setUsername(usuario);

		try {
			lista = usuarioService.ListarPorUsuario(5, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}



}
