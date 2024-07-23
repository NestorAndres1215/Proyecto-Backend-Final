package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.TbCupon;
import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;

public interface TbGenService {
	
	public List<Map<String, Object>> listarGenerales(int opcion, TbGen obj);
	public List<Map<String, Object>> listarGeneralesDetalle(int opcion, TbGenDev obj);
	void RegistrarTablaGeneral(int opcion, TbGen obj);
	void RegistrarTablaGeneralDetalle(int opcion, TbGenDev obj);
	void ActualizarTablaGeneral(int opcion, TbGen obj);
	void ActualizarTablaGeneralDetalle(int opcion, TbGenDev obj);
	void EliminarTablaGeneral(int opcion, TbGen obj);
	void EliminarTablaGeneralDetalle(int opcion, TbGenDev obj);
	boolean existsByCodigo(String codigo);
	boolean existsByClave(String clave);
	boolean existsByDescripcion(String Descripcion);
	boolean existsByClaveAndCodigo(String clave, String codigo);
	boolean  existeDescripcion(String Descripcion);
}
