package com.naat.proyectofutbol.controladores;

import java.io.IOException;
import java.util.*;

import com.naat.proyectofutbol.constrainst.Mensaje;
import com.naat.proyectofutbol.constrainst.UsuarioError;
import com.naat.proyectofutbol.entidades.Cupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.Compania;
import com.naat.proyectofutbol.repositorios.CompaniaRepository;
import com.naat.proyectofutbol.servicios.CompaniaService;

@RestController
@RequestMapping("/compania")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class CompaniaController {
	@Autowired
	private CompaniaService service;
	@Autowired
	private CompaniaRepository repository;


	@GetMapping("/listar")
	public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
		List<Map<String, Object>> lista;
		Compania obj = new Compania();

		try {
			lista = service.listar(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
e.printStackTrace();

			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
		}
	}

	@PutMapping("/actualizar/{com_codigo}")
	public ResponseEntity<String> guardarCompania(@PathVariable String com_codigo,
															   @RequestParam("nombre") String nombre, @RequestParam("telefono") String telefono,
															   @RequestParam("direccion") String direccion, @RequestParam("correo") String correo,
															   @RequestParam("pais") String pais, @RequestParam("sector") String sector,
															   @RequestParam("descripcion") String descripcion, @RequestParam("ruc") String ruc,
															   @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
															   @RequestParam("archivo") MultipartFile archivo) {
		Map<String, Object> response = new HashMap<>();
		try {
			if (!service.telefonoEsValido(telefono)) {
				return ResponseEntity.ok(UsuarioError.TELEFONO_DIGITOS.getMensaje());
			}
			if (!service.rucesValido(ruc)) {
				return ResponseEntity.ok(Mensaje.RUC_DIGITOS.getMensaje());
			}

			Compania obj = new Compania();
			obj.setCom_codigo(com_codigo);
			obj.setCom_nombre(nombre);
			obj.setCom_direccion(direccion);
			obj.setCom_telefono(telefono);
			obj.setCom_correo(correo);
			obj.setCom_pais(pais);
			obj.setCom_sector(sector);
			obj.setCom_ruc(ruc);
			obj.setCom_descripcion(descripcion);
			obj.setCom_fecha_de_fundacion(fecha);

			service.guardarImagen(com_codigo, obj, archivo);
			return ResponseEntity.ok(Mensaje.REGISTRO.getMensaje());

		} catch (IOException e) {
			return ResponseEntity.ok("Error al procesar el archivo.");
		}
	}


}
