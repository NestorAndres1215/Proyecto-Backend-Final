package com.naat.proyectofutbol.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.naat.proyectofutbol.entidades.TbUsuario;

import com.naat.proyectofutbol.modelo.TbLogin;

import com.naat.proyectofutbol.servicios.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// registrar usuarios normales
	/*
	 * @PostMapping("/") public ResponseEntity<UsuarioRol>
	 * guardarUsuario(@RequestBody UsuarioRol usuarios) throws Exception {
	 * usuarios.setUs_contra(this.bCryptPasswordEncoder.encode(usuarios.getUs_contra
	 * ())); return ResponseEntity.ok(usuarioService.guardarUsuario(usuarios));
	 * 
	 * }
	 */

	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> guardarUsuario(@RequestBody TbUsuario usuario) throws Exception {
	   
	    TbLogin user = new TbLogin();
	    user.setUs_codigo(usuario.getUl_codigo());
	    user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
	    user.setUsername(usuario.getUsername());
	    user.setUs_rol(usuario.getUl_rol());
	    
	    TbLogin loginGuardado = usuarioService.guardarlogin(user);
	    
	    TbUsuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
	    
	    // Crear un mapa para almacenar los objetos guardados
	    Map<String, Object> response = new HashMap<>();
	    response.put("usuario", usuarioGuardado);
	    response.put("login", loginGuardado);
	    
	    // Devolver el mapa en la respuesta
	    return ResponseEntity.ok(response);
	}


// registrar usuarios admin

	/*
	 * @PostMapping("/admin/") public Usuario guardarUsuarioAdmin(@RequestBody
	 * UsuarioRol usuario) { usuario.setPerfil("default.png");
	 * 
	 * usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()))
	 * ;
	 * 
	 * Set<UsuarioRol> usuarioRoles = new HashSet<>();
	 * 
	 * Rol rol = new Rol(); rol.setRolId(2L); rol.setRolNombre("ADMIN");
	 * 
	 * UsuarioRol usuarioRol = new UsuarioRol(); usuarioRol.setUsuario(usuario);
	 * usuarioRol.setRol(rol);
	 * 
	 * usuarioRoles.add(usuarioRol); return usuarioService.guardarUsuario(
	 * usuarioRoles); }
	 */



}
