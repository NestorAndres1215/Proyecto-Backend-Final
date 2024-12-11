package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.General;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.Compania;



public interface CompaniaService {

	List<Compania> findAll();
	public List<Map<String, Object>> listar(int opcion, Compania obj);
	public Compania guardarImagen(String com_codigo, Compania obj, MultipartFile archivo) throws IOException;
	boolean telefonoEsValido(String telefono);
	boolean rucesValido(String ruc);
}
