package com.naat.proyectofutbol.servicios;


import com.naat.proyectofutbol.entidades.Anexo;


import java.util.List;
import java.util.Map;

public interface AnexoService {
    public List<Map<String, Object>> listar(int opcion, Anexo obj);
    void registrar(int opcion, Anexo obj);
    void actualizar(int opcion, Anexo obj);
    void eliminar(int opcion, Anexo obj);
    boolean correoExistente(String correo);
    boolean telefonoExistente(String telefono);
    boolean codigoandtipoexistente(String codigo , String tipo);
    boolean numeroDocumentoExistente(String numeroDocumento);
    boolean nombrecompletoExistente(String nombrePrimario,String nombreSecundario,String apellidoPaterno,String apellidoMaterno);
    boolean telefonoEsValido(String telefono);
    boolean DNI(String numeroDocumento);
    boolean RUC(String numeroDocumento);
}
