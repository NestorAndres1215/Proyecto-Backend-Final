package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naat.proyectofutbol.entidades.TbGen;
import com.naat.proyectofutbol.entidades.TbGenDev;
import com.naat.proyectofutbol.repositorios.TbGenRepository;
import com.naat.proyectofutbol.servicios.TbGenService;
@Service
public class TbGenServiceImpl implements TbGenService {
	@Autowired
	private TbGenRepository repository;

    @Override
    public List<Map<String, Object>> listarGenerales(int opcion, TbGen obj) {
        return repository.ListaGenerales(opcion, obj.getTl_codigo(), obj.getTl_clave(), obj.getTl_descri1(), obj.getTl_descri2());
    }
    @Override
    public List<Map<String, Object>> listarGeneralesDetalle(int opcion, TbGenDev obj) {
        return repository.ListaGeneralesDetalle(opcion, obj.getTl_codigo(), obj.getTl_clave(), obj.getTl_descri1(), obj.getTl_descri2());
    }



}
