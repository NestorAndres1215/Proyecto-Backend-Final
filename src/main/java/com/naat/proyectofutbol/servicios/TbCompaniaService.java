package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbCompania;



public interface TbCompaniaService {

	List<TbCompania> findAll();
	public TbCompania guardarImagen(String com_codigo, TbCompania obj, MultipartFile archivo) throws IOException;
	boolean telefonoEsValido(String telefono);
	boolean rucesValido(String ruc);
}
