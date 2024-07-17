package com.naat.proyectofutbol.servicios;



import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbReclamo;


public interface TbReclamoService {
	public void enviarCorreoDisculpas(String destinatario, String asunto, String contenido);

    public void actualizarReclamo(TbReclamo reclamo);
    public TbReclamo guardarImagen(TbReclamo obj, MultipartFile archivo) throws IOException;
}