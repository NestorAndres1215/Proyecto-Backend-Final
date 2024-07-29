package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.General;
import com.naat.proyectofutbol.entidades.GeneralDev;

public interface GenService {
	
	public List<Map<String, Object>> listarGenerales(int opcion, General obj);
	public List<Map<String, Object>> listarGeneralesDetalle(int opcion, GeneralDev obj);
	void RegistrarTablaGeneral(int opcion, General obj);
	void RegistrarTablaGeneralDetalle(int opcion, GeneralDev obj);
	void ActualizarTablaGeneral(int opcion, General obj);
	void ActualizarTablaGeneralDetalle(int opcion, GeneralDev obj);
	void EliminarTablaGeneral(int opcion, General obj);
	void EliminarTablaGeneralDetalle(int opcion, GeneralDev obj);
	boolean existsByCodigo(String codigo);
	boolean existsByClave(String clave);
	boolean existsByDescripcion(String Descripcion);
	boolean existsByClaveAndCodigo(String clave, String codigo);
	boolean  existeDescripcion(String Descripcion);
}
