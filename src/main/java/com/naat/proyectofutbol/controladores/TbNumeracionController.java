package com.naat.proyectofutbol.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.constrainst.Numeracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naat.proyectofutbol.entidades.TbNumeracion;
import com.naat.proyectofutbol.servicios.TbNumeracionService;

@RestController
@RequestMapping("/numeracion")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class TbNumeracionController {
	
	@Autowired
	private TbNumeracionService service;

	@GetMapping(value = { "/listar" })
	public List<TbNumeracion> findAll(){
		return service.findAll();
	}

	@PostMapping("/registrar")
	public ResponseEntity<String> registroNumeracion(@RequestBody TbNumeracion numeracion) {
		try {
			service.RegistrarCompania(1, numeracion);
			return ResponseEntity.ok(Numeracion.REGISTRO_NUMERACION.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(Numeracion.ERROR_REGISTRO.getMensaje());
		}
	}


}
