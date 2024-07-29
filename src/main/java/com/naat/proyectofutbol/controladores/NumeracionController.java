package com.naat.proyectofutbol.controladores;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.Anexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naat.proyectofutbol.entidades.Numeracion;
import com.naat.proyectofutbol.servicios.NumeracionService;

@RestController
@RequestMapping("/numeracion")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class NumeracionController {
	
	@Autowired
	private NumeracionService service;

	@GetMapping(value = { "/listar" })
	public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
		List<Map<String, Object>> lista;
		Numeracion obj = new Numeracion();

		try {
			lista = service.listar(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<String> registroNumeracion(@RequestBody Numeracion numeracion) {
		try {
			service.RegistrarCompania(1, numeracion);
			return ResponseEntity.ok(com.naat.proyectofutbol.constrainst.Numeracion.REGISTRO_NUMERACION.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(com.naat.proyectofutbol.constrainst.Numeracion.ERROR_REGISTRO.getMensaje());
		}
	}


}
