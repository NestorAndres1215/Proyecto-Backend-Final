package com.naat.proyectofutbol.controladores;

import java.io.IOException;

import com.naat.proyectofutbol.constrainst.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbReclamo;
import com.naat.proyectofutbol.servicios.TbReclamoService;

@RestController
@RequestMapping("/reclamo")

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class TbReclamoController {
	@Autowired
	private TbReclamoService reclamoService;

	@PostMapping("/correo/{rec_codigo}/enviar-disculpas")
	public ResponseEntity<String> enviarDisculpas(@PathVariable String rec_codigo, @RequestBody String mensaje) {
		TbReclamo reclamo = new TbReclamo();

		String destinatario = reclamo.getRec_correo();
		String asunto = "Respuesta de disculpas para el reclamo #" + rec_codigo;
		String contenido = "Estimado/a " + reclamo.getRec_usuario() + ",\n\n"
				+ "Lamentamos profundamente los inconvenientes ocasionados por su reclamo. Queremos ofrecerle nuestras más sinceras disculpas y asegurarle que estamos trabajando para resolver la situación lo antes posible.\n\n"
				+ "Mensaje de disculpas: " + mensaje + "\n\n" + "--------------------------,\n" + "Atentamente,\n"
				+ "Equipo de Soporte";

		reclamoService.enviarCorreoDisculpas(destinatario, asunto, contenido);
		reclamo.setRec_estado("Reclamo Recibido");
		reclamoService.actualizarReclamo(reclamo);
		return ResponseEntity.ok(Mensaje.CORREO_ENVIADO.getMensaje());
	}

	@PostMapping("/")
	public ResponseEntity<String> agregarProducto(@RequestParam String usuario, @RequestParam String correo,
			@RequestParam String descripcion, @RequestParam String asunto, @RequestParam String tipoReclamo,
			@RequestParam String fecha, @RequestParam String hora, @RequestParam String estado,
			@RequestParam("imagen") MultipartFile imagen) throws IOException {

		try {
			if (imagen.isEmpty()) {
				return new ResponseEntity<>("Archivo vacío", HttpStatus.BAD_REQUEST);
			}
			TbReclamo reclamo = new TbReclamo();
			reclamo.setRec_usuario(usuario);
			reclamo.setRec_correo(correo);
			reclamo.setRec_descripcion(descripcion);
			reclamo.setRec_asunto(asunto);
			reclamo.setRec_tiporeclamo(tipoReclamo);
			reclamo.setRec_estado(estado);
			reclamo.setRec_fecha(fecha);
			reclamo.setRec_hora(hora);

			reclamoService.guardarImagen(reclamo, imagen);

			return new ResponseEntity<>("Imagen subida correctamente", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error procesando la solicitud: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
