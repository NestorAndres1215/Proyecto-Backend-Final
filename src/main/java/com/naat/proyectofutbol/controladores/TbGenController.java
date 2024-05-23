package com.naat.proyectofutbol.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;
import com.naat.proyectofutbol.servicios.TbGenService;

@RestController
@RequestMapping("/general")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class TbGenController {
	 @Autowired
	private TbGenService service;

	@GetMapping(value = { "/listaGenerales/" })
	public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
		List<Map<String, Object>> lista;
		TbGen obj = new TbGen();

		obj.setTl_clave("");
		obj.setTl_codigo("");
		obj.setTl_descri1("");
		obj.setTl_descri2("");
		try {
			lista = service.listarGenerales(1, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}

	}
	@GetMapping(value = { "/listaGeneralesDetalle/{codigo}" })
    public ResponseEntity<List<Map<String, Object>>> ListaGeneralesDetalle(@PathVariable("codigo") String codigo) {
        List<Map<String, Object>> lista;
        TbGenDev obj = new TbGenDev();

        // Utiliza el valor de "codigo" para establecer el campo correspondiente
        obj.setTl_codigo(codigo);
        obj.setTl_clave("");
        obj.setTl_descri1("");
        obj.setTl_descri2("");

        try {
            lista = service.listarGeneralesDetalle(0, obj);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            // Manejo de excepciones más robusto
            return ResponseEntity.status(500).body(null); // o puedes crear una respuesta más detallada
        }
    }
}
