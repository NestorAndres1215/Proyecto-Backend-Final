package com.naat.proyectofutbol.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<Map<String, Object[]>>> ListaNumeracion() throws Exception {
		List<Map<String, Object[]>> lista;
		TbNumeracion obj = new TbNumeracion();
		try {

			lista = service.listarNumeracion(0, obj);
			return ResponseEntity.ok(lista);

		} catch (Exception e) {
			throw new Exception("Error  al listar");
		}

	}

}
