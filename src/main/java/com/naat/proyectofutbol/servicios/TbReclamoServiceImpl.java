package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.TbReclamo;
import com.naat.proyectofutbol.repositorios.TbReclamoRepository;
import com.naat.proyectofutbol.servicios.TbReclamoService;

@Service
public class TbReclamoServiceImpl implements TbReclamoService {

	private final JavaMailSender javaMailSender;
	private final TbReclamoRepository reclamoRepository;

	@Autowired
	public TbReclamoServiceImpl(JavaMailSender javaMailSender, TbReclamoRepository reclamoRepository) {
		this.javaMailSender = javaMailSender;
		this.reclamoRepository = reclamoRepository;
	}

	public void actualizarReclamo(TbReclamo reclamo) {

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
	public TbReclamo guardarImagen(TbReclamo obj, MultipartFile archivo) throws IOException {

		TbReclamo reclamo = new TbReclamo();
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
