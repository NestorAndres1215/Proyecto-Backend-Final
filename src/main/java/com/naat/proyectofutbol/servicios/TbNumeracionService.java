package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.TbNumeracion;

public interface TbNumeracionService {
	public List<Map<String, Object[]>> listarNumeracion(int opcion, TbNumeracion obj);
}
