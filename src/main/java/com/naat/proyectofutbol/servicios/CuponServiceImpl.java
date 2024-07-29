package com.naat.proyectofutbol.servicios;

import com.naat.proyectofutbol.entidades.Cupon;
import com.naat.proyectofutbol.repositorios.CuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CuponServiceImpl implements CuponService {

    @Autowired
    private CuponRepository repository;
    @Override
    public List<Cupon> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Map<String, Object>> listar(int opcion, Cupon obj) {
        return repository.listar(opcion, obj.getCodigo(), obj.getCp_Tipocupon(), obj.getCp_Descripcion(), obj.getCp_Fechainicio(),obj.getCp_Fechafin(),obj.getCp_Descuento(), obj.getCp_Condiciones());

    }

    @Override
    public void RegistrarCupon(int opcion, Cupon obj) {
        repository.registrar(opcion, obj.getCodigo(), obj.getCp_Tipocupon(), obj.getCp_Descripcion(), obj.getCp_Fechainicio(),obj.getCp_Fechafin(),obj.getCp_Descuento(), obj.getCp_Condiciones());
    }

    @Override
    public void ActualizarCupon(int opcion, Cupon obj) {
        repository.registrar(opcion, obj.getCodigo(), obj.getCp_Tipocupon(), obj.getCp_Descripcion(), obj.getCp_Fechainicio(),obj.getCp_Fechafin(),obj.getCp_Descuento(), obj.getCp_Condiciones());

    }

    @Override
    public boolean CuponEsValido(String cupon_Codigocupon) {
        return repository.existsByCodigo(cupon_Codigocupon);
    }
}
