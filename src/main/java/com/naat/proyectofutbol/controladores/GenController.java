package com.naat.proyectofutbol.controladores;


import java.util.List;
import java.util.Map;
import com.naat.proyectofutbol.constrainst.TablaGenerales;
import com.naat.proyectofutbol.constrainst.UsuarioError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.naat.proyectofutbol.entidades.General;
import com.naat.proyectofutbol.entidades.GeneralDev;
import com.naat.proyectofutbol.servicios.GenService;


@RestController
@RequestMapping("/general")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class GenController {
	 @Autowired
	private GenService service;

	@GetMapping(value = { "/listaGenerales/" })
	public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
		List<Map<String, Object>> lista;
		General obj = new General();
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
        GeneralDev obj = new GeneralDev();
			obj.setCodigo(codigo);
        try {
            lista = service.listarGeneralesDetalle(0, obj);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

	@PostMapping("/registrar")
	public ResponseEntity<String> registrargenerales(@RequestBody General obj) {
		try {
			if (service.existsByCodigo(obj.getCodigo())) {
				return ResponseEntity.ok(TablaGenerales.CODIGO_EXISTENTE.getMensaje());
			}
			if (service.existsByClave(obj.getClave())) {
				return ResponseEntity.ok(TablaGenerales.CLAVE_EXISTENTE.getMensaje());
			}
			if (service.existsByDescripcion(obj.getDescripcion())) {
				return ResponseEntity.ok(TablaGenerales.DESCRIPCION_EXISTE.getMensaje());
			}

			service.RegistrarTablaGeneral(2, obj);
			return ResponseEntity.ok(TablaGenerales.REGISTRO_GENERALES.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(TablaGenerales.ERROR_REGISTRO.getMensaje());
		}
	}
	@PostMapping("/registrardev")
	public ResponseEntity<String> registrargeneralesdev(@RequestBody GeneralDev obj) {
		try {
			if (service.existsByClaveAndCodigo(obj.getClave(), obj.getCodigo())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(TablaGenerales.CLAVE_CODIGO_EXISTENTE.getMensaje());
			}
			if (service.existeDescripcion(obj.getDescripcion())) {
				return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(TablaGenerales.DESCRIPCION_EXISTE.getMensaje());
			}

			service.RegistrarTablaGeneralDetalle(3, obj);
			return ResponseEntity.ok("se registro");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(TablaGenerales.ERROR_DETALLE.getMensaje());
		}
	}
	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarTabla(@RequestBody General obj) {
		try {
			service.ActualizarTablaGeneral(5, obj);
			return ResponseEntity.ok(TablaGenerales.ACTUALIZAR.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(TablaGenerales.ERROR_ACTUALZIACION.getMensaje());
		}
	}
	@PutMapping("/actualizardev")
	public ResponseEntity<String> actualizarTablaDev(@RequestBody GeneralDev obj) {
		try {
			service.ActualizarTablaGeneralDetalle(4, obj);
			return ResponseEntity.ok(TablaGenerales.ACTUALIZAR_DETALLE.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(TablaGenerales.ERROR_ACTUALZIACION_DETALLES.getMensaje());
		}
	}
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<String> eliminarBini(@PathVariable("codigo") String codigo) {
		String codigoSinCeros = codigo.replaceFirst("^0+(?!$)", "");
		General obj = new General(codigo, "", "", "");
		GeneralDev dev = new GeneralDev("", codigoSinCeros, "", "");

		try {
			service.EliminarTablaGeneral(6, obj);
			service.EliminarTablaGeneralDetalle(7,dev);
			return ResponseEntity.ok(TablaGenerales.ELIMINAR_TOTAL.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(TablaGenerales.ELIMINAR_TOTAL.getMensaje());
		}
	}
	@DeleteMapping("/eliminardev/{codigo}")
	public ResponseEntity<String> eliminarDev(@PathVariable("codigo") String codigo) {
		GeneralDev obj = new GeneralDev("",codigo,"","");
		try {
			service.EliminarTablaGeneralDetalle(7, obj);
			return ResponseEntity.ok(TablaGenerales.ELIMINAR_TOTAL.getMensaje());
		} catch (Exception e) {
			return ResponseEntity.ok(TablaGenerales.ERROR_ELIMINACION.getMensaje());
		}
	}
}
