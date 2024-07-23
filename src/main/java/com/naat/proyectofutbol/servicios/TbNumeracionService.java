package com.naat.proyectofutbol.servicios;

import java.util.List;

import com.naat.proyectofutbol.entidades.TbNumeracion;

public interface TbNumeracionService {

	public List<TbNumeracion> findAll();
 	void RegistrarCompania(int opcion, TbNumeracion obj);
}
