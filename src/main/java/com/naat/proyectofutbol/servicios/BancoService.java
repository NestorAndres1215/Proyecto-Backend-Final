package com.naat.proyectofutbol.servicios;


import com.naat.proyectofutbol.entidades.Banco;
import java.util.List;
import java.util.Map;

public interface BancoService  {
    public List<Map<String, Object>> listar(int opcion, Banco obj);
    void registrar(int opcion ,Banco obj);
    void actualizar(int opcion,Banco obj);
    void eliminar(int opcion , Banco obj);
    boolean codigoexiste(String codigo);
    boolean cuentaexiste(String cuenta);
    boolean numeroCuenta(String numero);
    boolean codigovalido(String codigo);

}
