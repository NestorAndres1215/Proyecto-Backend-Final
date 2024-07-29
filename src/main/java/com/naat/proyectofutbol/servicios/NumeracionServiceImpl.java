package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naat.proyectofutbol.entidades.Numeracion;
import com.naat.proyectofutbol.repositorios.NumeracionRepository;

@Service
public class NumeracionServiceImpl implements NumeracionService {
	@Autowired
	private NumeracionRepository repository;


	@Override
	public List<Numeracion> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Map<String, Object>> listar(int opcion, Numeracion obj) {
		return repository.listar(opcion,obj.getNum_codigo(),obj.getNum_descripcion(),obj.getNum_cantidad(),obj.getNum_fecha());

	}

	@Override
	public void RegistrarCompania(int opcion, Numeracion obj) {
	 repository.registrar(opcion,obj.getNum_codigo(),obj.getNum_descripcion(),obj.getNum_cantidad(),obj.getNum_fecha());

	}




}
