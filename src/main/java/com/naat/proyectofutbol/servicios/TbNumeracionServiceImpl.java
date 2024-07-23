package com.naat.proyectofutbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naat.proyectofutbol.entidades.TbNumeracion;
import com.naat.proyectofutbol.repositorios.TbNumeracionRepository;

@Service
public class TbNumeracionServiceImpl implements TbNumeracionService {
	@Autowired
	private TbNumeracionRepository repository;


	@Override
	public List<TbNumeracion> findAll() {
		return repository.findAll();
	}

	@Override
	public void RegistrarCompania(int opcion, TbNumeracion obj) {
	 repository.registrar(opcion,obj.getNum_codigo(),obj.getNum_descripcion(),obj.getNum_cantidad(),obj.getNum_fecha());

	}




}
