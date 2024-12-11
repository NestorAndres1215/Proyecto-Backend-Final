package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.General;
import com.naat.proyectofutbol.entidades.Numeracion;

public interface NumeracionService {

	public List<Numeracion> findAll();
	public List<Map<String, Object>> listar(int opcion, Numeracion obj);
 	void RegistrarCompania(int opcion, Numeracion obj);
}
