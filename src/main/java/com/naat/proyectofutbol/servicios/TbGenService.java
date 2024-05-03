package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;

public interface TbGenService {
	
	public List<Map<String, Object[]>> listarGenerales(int opcion, TbGen obj);
	public List<Map<String, Object[]>> listarGeneralesDetalle(int opcion, TbGenDev obj);
}
