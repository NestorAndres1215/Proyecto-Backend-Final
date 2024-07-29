package com.naat.proyectofutbol.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.constrainst.Mensaje;
import com.naat.proyectofutbol.constrainst.UsuarioError;
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
	public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		String ultimoCodigoUsuario = usuarioService.obtenerUltimoCodigoUsuario();

		String nuevoCodigoUsuario = String.valueOf(Integer.parseInt(ultimoCodigoUsuario) + 1);
		usuario.setUl_codigo("0" + nuevoCodigoUsuario);
		Login user = new Login();
		user.setUs_codigo("0" + nuevoCodigoUsuario);
		user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		user.setUsername(usuario.getUsername());
		user.setUs_rol(usuario.getUl_rol());

		try {

			if (usuarioService.usuarioExistePorUsername(usuario.getUsername())) {
				return ResponseEntity.ok(UsuarioError.USUARIO_EXISTENTE.getMensaje());
			}
			if (usuarioService.usuarioExistePorEmail(usuario.getCorreo())) {
				return ResponseEntity.ok(UsuarioError.CORREO_EXISTENTE.getMensaje());
			}
			if (usuarioService.usuarioExistePorTelefono(usuario.getTelefono())) {
				return ResponseEntity.ok(UsuarioError.TELEFONO_EXISTENTE.getMensaje());
			}
			if (!usuarioService.telefonoEsValido(usuario.getTelefono())) {
				return ResponseEntity.ok(UsuarioError.TELEFONO_DIGITOS.getMensaje());
			}

			 usuarioService.guardarlogin(user);
			 usuarioService.guardarUsuario(usuario);

			return ResponseEntity.ok(Mensaje.REGISTRO.getMensaje());
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}
	}

	@GetMapping(value = { "/listaUsuario/" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaUsuario() throws Exception {
		List<Map<String, Object[]>> lista;
		Usuario obj = new Usuario();

		obj.setUl_codigo("");
		obj.setUsername("");
		obj.setPassword("");
		obj.setUl_nombre("");
		obj.setUl_apellido("");
		obj.setCorreo("");
		obj.setTelefono("");
		obj.setUl_direccion("");
		obj.setUl_rol("");
		try {
			System.out.println(obj);
			lista = usuarioService.listarUsuario(0, obj);

			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@PutMapping("/actualizarUsuario/")
	public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario) {
		Map<String, Object> response = new HashMap<>();

		try {

			if (!usuarioService.telefonoEsValido(usuario.getTelefono())) {
				return ResponseEntity.ok(UsuarioError.TELEFONO_DIGITOS.getMensaje());
			}
			Login user = new Login();
			user.setUs_codigo(usuario.getUl_codigo());
			user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
			user.setUsername(usuario.getUsername());
			user.setUs_rol(usuario.getUl_rol());

			Login loginGuardado = usuarioService.guardarlogin(user);

			usuarioService.actualizarUsuario(1, usuario);

			response.put("success", true);
			response.put("message", "Usuario actualizado correctamente");
			response.put("login", loginGuardado);
			return ResponseEntity.ok(response.toString());

		} catch (Exception e) {
			return ResponseEntity.ok("Hubo un error");
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
		obj.setUsername("");
		obj.setPassword("");
		obj.setUl_nombre("");
		obj.setUl_apellido("");
		obj.setCorreo("");
		obj.setTelefono("");
		obj.setUl_direccion("");
		obj.setUl_rol("");
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

		obj.setUl_codigo("");
		obj.setUsername("");
		obj.setPassword("");
		obj.setUl_nombre("");
		obj.setUl_apellido("");
		obj.setCorreo("");
		obj.setTelefono("");
		obj.setUl_direccion("");
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

		obj.setUl_codigo("");
		obj.setUsername(usuario);
		obj.setPassword("");
		obj.setUl_nombre("");
		obj.setUl_apellido("");
		obj.setCorreo("");
		obj.setTelefono("");
		obj.setUl_direccion("");
		obj.setUl_rol("");
		try {
			lista = usuarioService.ListarPorUsuario(5, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

}
