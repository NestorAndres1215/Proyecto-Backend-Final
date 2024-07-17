package com.naat.proyectofutbol.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.naat.proyectofutbol.dto.CompaniaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.TbCompania;
import com.naat.proyectofutbol.repositorios.TbCompaniaRepository;
import com.naat.proyectofutbol.servicios.TbCompaniaService;

@RestController
@RequestMapping("/compania")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class TbCompaniaController {
	@Autowired
	private TbCompaniaService service;
	@Autowired
	private TbCompaniaRepository repository;

	@GetMapping(value = { "/listaCompania" })
	public ResponseEntity<List<Map<String, Object[]>>> ListaCompania() throws Exception {
		List<Map<String, Object[]>> lista;
		TbCompania obj = new TbCompania();

		try {
			lista = service.listaCompania(0, obj);
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			throw new Exception("Error : " + e.getMessage());
		}

	}

	@GetMapping("/listar")
	public List<TbCompania> obtenerCategoriasActivadas() {
		return repository.findAll();
	}

	@PutMapping("/actualizar/{com_codigo}")
	public ResponseEntity<String> guardarCompania(@PathVariable String com_codigo,
			@RequestParam("nombre") String nombre, @RequestParam("telefono") String telefono,
			@RequestParam("direccion") String direccion, @RequestParam("correo") String correo,
			@RequestParam("pais") String pais, @RequestParam("sector") String sector,
			@RequestParam("descripcion") String descripcion, @RequestParam("ruc") String ruc,
			@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
			@RequestParam("archivo") MultipartFile archivo) {

		try {

			TbCompania obj = new TbCompania();
			if(archivo==null){
				obj.setCom_logo(obj.getCom_logo());

			}
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

			return new ResponseEntity<>("SE REGISTRO CORRECTAMENTE", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("ERROR : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
