package com.naat.proyectofutbol.servicios;

import com.naat.proyectofutbol.entidades.Anexo;

import com.naat.proyectofutbol.repositorios.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnexoServiceImpl implements AnexoService {
    @Autowired
    private AnexoRepository repository;


    @Override
    public List<Map<String, Object>> listar(int opcion, Anexo obj) {
        return repository.ListaGenerales(opcion, obj.getCodigo(), obj.getTipo(), obj.getNombrePrimario(),
                obj.getNombreSecundario(), obj.getApellidoPaterno(),obj.getApellidoMaterno(), obj.getTipoDocumento(),
                obj.getNumeroDocumento(),obj.getTipoPersona(),obj.getAl_direccion(),obj.getAl_area(),obj.getAl_tipcargo(),obj.getCorreo(),obj.getTelefono());
    }

    @Override
    public void registrar(int opcion, Anexo obj) {
        repository.registrar(opcion, obj.getCodigo(), obj.getTipo(), obj.getNombrePrimario(),
                obj.getNombreSecundario(), obj.getApellidoPaterno(),obj.getApellidoMaterno(), obj.getTipoDocumento(),
                obj.getNumeroDocumento(),obj.getTipoPersona(),obj.getAl_direccion(),obj.getAl_area(),obj.getAl_tipcargo(),obj.getCorreo(),obj.getTelefono());
    }
    @Override
    public void actualizar(int opcion, Anexo obj) {
        repository.actualizar(opcion, obj.getCodigo(), obj.getTipo(), obj.getNombrePrimario(),
                obj.getNombreSecundario(), obj.getApellidoPaterno(),obj.getApellidoMaterno(), obj.getTipoDocumento(),
                obj.getNumeroDocumento(),obj.getTipoPersona(),obj.getAl_direccion(),obj.getAl_area(),obj.getAl_tipcargo(),obj.getCorreo(),obj.getTelefono());
    }

    @Override
    public void eliminar(int opcion, Anexo obj) {
    repository.eliminar(opcion, obj.getCodigo(), obj.getTipo(), obj.getNombrePrimario(),
            obj.getNombreSecundario(), obj.getApellidoPaterno(),obj.getApellidoMaterno(), obj.getTipoDocumento(),
            obj.getNumeroDocumento(),obj.getTipoPersona(),obj.getAl_direccion(),obj.getAl_area(),obj.getAl_tipcargo(),obj.getCorreo(),obj.getTelefono());
    }

    @Override
    public boolean correoExistente(String correo) {
        return repository.existsByCorreo(correo);
    }

    @Override
    public boolean telefonoExistente(String telefono) {
        return repository.existsByTelefono(telefono);
    }

    @Override
    public boolean codigoandtipoexistente(String codigo, String tipo) {
        return repository.existsByTipoAndCodigo(tipo,codigo);
    }

    @Override
    public boolean numeroDocumentoExistente(String numeroDocumento) {
        return repository.existsByNumeroDocumento(numeroDocumento);
    }

    @Override
    public boolean nombrecompletoExistente(String nombrePrimario, String nombreSecundario, String apellidoPaterno, String apellidoMaterno) {
        return repository.existsByNombrePrimarioAndNombreSecundarioAndApellidoPaternoAndApellidoMaterno(nombrePrimario,nombreSecundario,apellidoPaterno,apellidoMaterno);
    }

    public boolean telefonoEsValido(String telefono) {
        return telefono.matches("\\d{9}");
    }


    @Override
    public boolean DNI(String numeroDocumento) {
        return numeroDocumento.matches("\\d{8}");
    }
    @Override
    public boolean RUC(String numeroDocumento) {
        return numeroDocumento.matches("\\d{11}");
    }

}
