package com.naat.proyectofutbol.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.naat.proyectofutbol.entidades.TbUsuario;
import com.naat.proyectofutbol.modelo.TbLogin;
import com.naat.proyectofutbol.servicios.TbUsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class TbUsuarioController {

	@Autowired
	private TbUsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> guardarUsuario(@RequestBody TbUsuario usuario) throws Exception {
		String ultimoCodigoUsuario = usuarioService.obtenerUltimoCodigoUsuario();
		String nuevoCodigoUsuario = String.valueOf(Integer.parseInt(ultimoCodigoUsuario) + 1);
		usuario.setUl_codigo("00" + nuevoCodigoUsuario);
		TbLogin user = new TbLogin();
		user.setUs_codigo("00" + nuevoCodigoUsuario);
		user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		user.setUsername(usuario.getUsername());
		user.setUs_rol(usuario.getUl_rol());
		try {
			TbLogin loginGuardado = usuarioService.guardarlogin(user);
			TbUsuario usuarioGuardado = usuarioService.guardarUsuario(usuario);

			Map<String, Object> response = new HashMap<>();
			response.put("usuario", usuarioGuardado);
			response.put("login", loginGuardado);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@GetMapping(value = { "/listaUsuario/" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaUsuario() throws Exception {
		List<Map<String, Object[]>> lista;
		TbUsuario obj = new TbUsuario();

		obj.setUl_codigo("");
		obj.setUsername("");
		obj.setPassword("");
		obj.setUl_nombre("");
		obj.setUl_apellido("");
		obj.setUl_correo("");
		obj.setUl_telefono("");
		obj.setUl_direccion("");
		obj.setUl_rol("");
		try {
			lista = usuarioService.listarUsuario(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}

	@PutMapping("/actualizarUsuario/")
	public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody TbUsuario usuario) {
		Map<String, Object> response = new HashMap<>();

		try {

			TbLogin user = new TbLogin();
			user.setUs_codigo(usuario.getUl_codigo());
			user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
			user.setUsername(usuario.getUsername());
			user.setUs_rol(usuario.getUl_rol());

			TbLogin loginGuardado = usuarioService.guardarlogin(user);

			usuarioService.actualizarUsuario(1, usuario);

			response.put("success", true);
			response.put("message", "Usuario actualizado correctamente");
			response.put("login", loginGuardado);
		} catch (Exception e) {

			response.put("success", false);
			response.put("message", "Error al actualizar usuario: " + e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/eliminarUsuario/{codigo}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable("codigo") String codigo) {
	    Map<String, Object> salida = new HashMap<>();

	    try {
	    	TbUsuario obj = new TbUsuario();
	        // Llamar al servicio para eliminar el usuario con el código proporcionado
	        usuarioService.eliminarUsuario(2, obj);
	        salida.put("mensaje", "Usuario eliminado correctamente");
	    } catch (Exception e) {
	        e.printStackTrace();
	        salida.put("mensaje", "Error al eliminar usuario: " + e.getMessage());
	    }

	    return ResponseEntity.ok(salida);
	}


}
