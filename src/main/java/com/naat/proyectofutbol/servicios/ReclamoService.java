package com.naat.proyectofutbol.servicios;



import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.Reclamo;


public interface ReclamoService {
	public void enviarCorreoDisculpas(String destinatario, String asunto, String contenido);

    public void actualizarReclamo(Reclamo reclamo);
    public Reclamo guardarImagen(Reclamo obj, MultipartFile archivo) throws IOException;
}