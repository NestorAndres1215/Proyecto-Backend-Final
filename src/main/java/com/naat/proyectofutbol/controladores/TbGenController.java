package com.naat.proyectofutbol.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;
import com.naat.proyectofutbol.servicios.TbGenService;

public class TbGenController {

	private TbGenService service;

	@GetMapping(value = { "/listaGenerales/" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaGenerales() throws Exception {
		List<Map<String, Object[]>> lista;
		TbGen obj = new TbGen();

		obj.setTl_clave("");
		obj.setTl_codigo("");
		obj.setTl_descri1("");
		obj.setTl_descri2("");
		try {
			lista = service.listarGenerales(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}
	@GetMapping(value = { "/listaGeneralesDetalle/" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaGeneralesDetalle() throws Exception {
		List<Map<String, Object[]>> lista;
		TbGenDev obj = new TbGenDev();

		obj.setTl_clave("");
		obj.setTl_codigo("");
		obj.setTl_descri1("");
		obj.setTl_descri2("");
		try {
			lista = service.listarGeneralesDetalle(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}
}
