package com.naat.proyectofutbol.controladores;

import java.security.Principal;

import com.naat.proyectofutbol.constrainst.UsuarioError;
import com.naat.proyectofutbol.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.naat.proyectofutbol.configuraciones.JwtUtils;
import com.naat.proyectofutbol.modelo.JwtRequest;
import com.naat.proyectofutbol.modelo.JwtResponse;
import com.naat.proyectofutbol.modelo.Login;
import com.naat.proyectofutbol.servicios.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private UsuarioService usuarioService;
	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			if(!usuarioService.usuarioExistePorUsername(jwtRequest.getUsername())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.USUARIO_NO_ENCONTRADO.getMensaje());  // Salir del método para evitar autenticación
			}
			if(!usuarioService.existsByUsernameAndPassword(jwtRequest.getUsername(), jwtRequest.getPassword())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(UsuarioError.ERROR_USUARIO.getMensaje());  // Salir del método para evitar autenticación
			}
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception exception) {
			return ResponseEntity.ok(UsuarioError.USUARIO_NO_ENCONTRADO.getMensaje());
		}
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	@GetMapping("/actual-usuario")
	public Login obtenerUsuarioActual(Principal principal) {
		return (Login) this.userDetailsService.loadUserByUsername(principal.getName());
	}

}
