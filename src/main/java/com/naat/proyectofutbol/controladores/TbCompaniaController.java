package com.naat.proyectofutbol.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
			throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
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
			// Validate inputs (example)
			if (archivo.isEmpty()) {
				return new ResponseEntity<>("Archivo vacío", HttpStatus.BAD_REQUEST);
			}

			// Create and populate the TbCompania object
			TbCompania obj = new TbCompania();
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

			// Save the image and company details
			service.guardarImagen(com_codigo, obj, archivo);

			return new ResponseEntity<>("Imagen subida correctamente", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("Error subiendo la imagen: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>("Error procesando la solicitud: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{com_codigo}")
	public ResponseEntity<TbCompania> actualizarCategoria(@PathVariable String com_codigo,
			@RequestParam("nombre") String nombre, @RequestParam("telefono") String telefono,
			@RequestParam("direccion") String direccion, @RequestParam("correo") String correo,
			@RequestParam("pais") String pais, @RequestParam("sector") String sector,
			@RequestParam("descripcion") String descripcion, @RequestParam("ruc") String ruc,
			@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
			@RequestParam(value = "imagen", required = false) MultipartFile archivo) throws IOException {

		Optional<TbCompania> optionalCategoria = repository.findById(com_codigo);
		if (optionalCategoria.isPresent()) {
			TbCompania obj = optionalCategoria.get();
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

			if (archivo != null && !archivo.isEmpty()) {
				byte[] bytesImagen = archivo.getBytes();
				obj.setCom_logo(bytesImagen);
			}

			TbCompania categoriaActualizada = repository.save(obj);
			return ResponseEntity.ok(categoriaActualizada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
