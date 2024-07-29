package com.naat.proyectofutbol.servicios;

import java.util.List;
import java.util.Map;
import com.naat.proyectofutbol.repositorios.GenDevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naat.proyectofutbol.entidades.General;
import com.naat.proyectofutbol.entidades.GeneralDev;
import com.naat.proyectofutbol.repositorios.GenRepository;

@Service
public class GenServiceImpl implements GenService {
	@Autowired
	private GenRepository repository;
    @Autowired
    private GenDevRepository devrepository;

    @Override
    public List<Map<String, Object>> listarGenerales(int opcion, General obj) {
        return repository.ListaGenerales(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }
    @Override
    public List<Map<String, Object>> listarGeneralesDetalle(int opcion, GeneralDev obj) {
        return devrepository.ListaGeneralesDetalle(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void RegistrarTablaGeneral(int opcion, General obj) {
        repository.RegistrarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void RegistrarTablaGeneralDetalle(int opcion, GeneralDev obj) {
        devrepository.RegistrarTablaGeneralDetalle(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());

    }

    @Override
    public void ActualizarTablaGeneral(int opcion, General obj) {
        repository.ActualizarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void ActualizarTablaGeneralDetalle(int opcion, GeneralDev obj) {
        devrepository.Actualizar(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());

    }

    @Override
    public void EliminarTablaGeneral(int opcion, General obj) {
        repository.EliminarTablaGeneral(opcion, obj.getCodigo(), obj.getClave(), obj.getDescripcion(), obj.getTl_descri2());
    }

    @Override
    public void EliminarTablaGeneralDetalle(int opcion, GeneralDev obj) {
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
