package com.naat.proyectofutbol.servicios;
import com.naat.proyectofutbol.entidades.Cupon;
import java.util.List;
import java.util.Map;

public interface CuponService {
    public List<Cupon> findAll();
    public List<Map<String, Object>> listar(int opcion, Cupon obj);
    void RegistrarCupon(int opcion, Cupon obj);
    void ActualizarCupon(int opcion, Cupon obj);
    boolean CuponEsValido(String cupon_Codigocupon);
}
