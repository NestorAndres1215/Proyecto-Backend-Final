package com.naat.proyectofutbol.servicios;

import com.naat.proyectofutbol.entidades.TbCupon;
import com.naat.proyectofutbol.repositorios.TbCuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbCuponServiceImpl implements TbCuponService{

    @Autowired
    private TbCuponRepository  repository;
    @Override
    public List<TbCupon> findAll() {
        return repository.findAll();
    }

    @Override
    public void RegistrarCupon(int opcion, TbCupon obj) {
        repository.registrar(opcion, obj.getCodigo(), obj.getCupon_Tipocupon(), obj.getCupon_Descripcion(), obj.getCupon_Fechainicio(),obj.getCupon_Fechafin(),obj.getCupon_Descuento(), obj.getCupon_Condiciones());
    }

    @Override
    public void ActualizarCupon(int opcion, TbCupon obj) {
        repository.registrar(opcion, obj.getCodigo(), obj.getCupon_Tipocupon(), obj.getCupon_Descripcion(), obj.getCupon_Fechainicio(),obj.getCupon_Fechafin(),obj.getCupon_Descuento(), obj.getCupon_Condiciones());

    }

    @Override
    public boolean CuponEsValido(String cupon_Codigocupon) {
        return repository.existsByCodigo(cupon_Codigocupon);
    }
}
