package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.Reclamo;
import com.naat.proyectofutbol.repositorios.ReclamoRepository;

@Service
public class ReclamoServiceImpl implements ReclamoService {

	private final JavaMailSender javaMailSender;
	private final ReclamoRepository reclamoRepository;

	@Autowired
	public ReclamoServiceImpl(JavaMailSender javaMailSender, ReclamoRepository reclamoRepository) {
		this.javaMailSender = javaMailSender;
		this.reclamoRepository = reclamoRepository;
	}

	public void actualizarReclamo(Reclamo reclamo) {

		reclamoRepository.save(reclamo);
	}

	public void enviarCorreoDisculpas(String destinatario, String asunto, String contenido) {
		SimpleMailMessage correo = new SimpleMailMessage();
		correo.setTo(destinatario);
		correo.setSubject(asunto);
		correo.setText(contenido);

		javaMailSender.send(correo);
	}

	@Override
	public Reclamo guardarImagen(Reclamo obj, MultipartFile archivo) throws IOException {

		Reclamo reclamo = new Reclamo();
		reclamo.setRec_codigo(obj.getRec_codigo());
		reclamo.setRec_usuario(obj.getRec_usuario());
		reclamo.setRec_correo(obj.getRec_correo());
		reclamo.setRec_descripcion(obj.getRec_descripcion());
		reclamo.setRec_asunto(obj.getRec_asunto());
		reclamo.setRec_tiporeclamo(obj.getRec_tiporeclamo());
		reclamo.setRec_fecha(obj.getRec_fecha());
		reclamo.setRec_estado(obj.getRec_estado());
		reclamo.setRec_hora(obj.getRec_hora());
		reclamo.setRec_archivo(archivo.getBytes());
		return reclamoRepository.save(reclamo);
	}

}
