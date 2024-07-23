package com.naat.proyectofutbol.servicios;

import com.naat.proyectofutbol.entidades.TbCupon;
import com.naat.proyectofutbol.entidades.TbNumeracion;
import org.springframework.stereotype.Service;


import java.util.List;

public interface TbCuponService {
    public List<TbCupon> findAll();
    void RegistrarCupon(int opcion, TbCupon obj);
    void ActualizarCupon(int opcion, TbCupon obj);
    boolean CuponEsValido(String cupon_Codigocupon);
}
