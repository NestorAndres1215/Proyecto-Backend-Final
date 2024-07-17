package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naat.proyectofutbol.entidades.TbNumeracion;
import com.naat.proyectofutbol.repositorios.TbNumeracionRepository;
import com.naat.proyectofutbol.servicios.TbNumeracionService;
@Service
public class TbNumeracionServiceImpl implements TbNumeracionService {
	@Autowired
	private TbNumeracionRepository repository;

	@Override
	public List<Map<String, Object[]>> listarNumeracion(int opcion, TbNumeracion obj) {
		return repository.listaCompania(opcion, obj.getNum_codigo(), obj.getNum_descripcion(), obj.getNum_cantidad(),
				obj.getNum_fecha());
	}

}
