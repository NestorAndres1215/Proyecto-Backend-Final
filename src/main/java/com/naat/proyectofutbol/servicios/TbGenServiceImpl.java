package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;

import com.naat.proyectofutbol.repositorios.TbGenDevRepository;
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
    @Autowired
    private TbGenDevRepository devrepository;

    @Override
    public List<Map<String, Object>> listarGenerales(int opcion, TbGen obj) {
        return repository.ListaGenerales(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }
    @Override
    public List<Map<String, Object>> listarGeneralesDetalle(int opcion, TbGenDev obj) {
        return devrepository.ListaGeneralesDetalle(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void RegistrarTablaGeneral(int opcion, TbGen obj) {
        repository.RegistrarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void RegistrarTablaGeneralDetalle(int opcion, TbGenDev obj) {
        devrepository.RegistrarTablaGeneralDetalle(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());

    }

    @Override
    public void ActualizarTablaGeneral(int opcion, TbGen obj) {
        repository.ActualizarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void ActualizarTablaGeneralDetalle(int opcion, TbGenDev obj) {
        devrepository.Actualizar(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());

    }

    @Override
    public void EliminarTablaGeneral(int opcion, TbGen obj) {
        repository.EliminarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void EliminarTablaGeneralDetalle(int opcion, TbGenDev obj) {
        devrepository.Eliminar(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());

    }

    @Override
    public boolean existsByCodigo(String codigo) {
        return repository.existsByCodigo(codigo);
    }

    @Override
    public boolean existsByClave(String clave) {
        return repository.existsByClave(clave);
    }

    @Override
    public boolean existsByDescripcion(String Descripcion) {
        return repository.existsByDescripcion(Descripcion);
    }

    @Override
    public boolean existsByClaveAndCodigo(String clave, String codigo) {
        return devrepository.existsByClaveAndCodigo(clave,codigo);
    }

    @Override
    public boolean existeDescripcion(String Descripcion) {
        return devrepository.existsByDescripcion(Descripcion);
    }


}
