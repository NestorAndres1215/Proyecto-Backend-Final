package com.naat.proyectofutbol.servicios.impl;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;
import com.naat.proyectofutbol.repositorios.tbGenRepository;
import com.naat.proyectofutbol.servicios.TbGenService;

public class TbGenServiceImpl implements TbGenService {
	
	private tbGenRepository repository;

	@Override
	public List<Map<String, Object[]>> listarGenerales(int opcion, TbGen obj) {
		
		return repository.ListaGenerales(opcion,obj.getTl_codigo(),obj.getTl_clave(),obj.getTl_descri1(),obj.getTl_descri2());
	}

	@Override
	public List<Map<String, Object[]>> listarGeneralesDetalle(int opcion, TbGenDev obj) {
		// TODO Auto-generated method stub
		return repository.ListaGeneralesDetalle(opcion,obj.getTl_codigo(),obj.getTl_clave(),obj.getTl_descri1(),obj.getTl_descri2());
	}



}
