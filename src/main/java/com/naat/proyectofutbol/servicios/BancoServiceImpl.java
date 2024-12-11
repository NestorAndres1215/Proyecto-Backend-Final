package com.naat.proyectofutbol.servicios;

import com.naat.proyectofutbol.entidades.Banco;
import com.naat.proyectofutbol.repositorios.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BancoServiceImpl implements BancoService{

    @Autowired
    private BancoRepository repository;
    @Override
    public List<Map<String, Object>> listar(int opcion, Banco obj) {
        return repository.listar(opcion,obj.getCodigoBanco(), obj.getCuenta(),obj.getEntidadFinanciera(),obj.getNombreBanco(),obj.getNumeroCuenta(),obj.getTipoMoneda());
    }

    @Override
    public void registrar(int opcion, Banco obj) {
    repository.registrar(opcion,obj.getCodigoBanco(), obj.getCuenta(),obj.getEntidadFinanciera(),obj.getNombreBanco(),obj.getNumeroCuenta(),obj.getTipoMoneda());
    }

    @Override
    public void actualizar(int opcion, Banco obj) {
        repository.actualizar(opcion,obj.getCodigoBanco(), obj.getCuenta(),obj.getEntidadFinanciera(),obj.getNombreBanco(),obj.getNumeroCuenta(),obj.getTipoMoneda());
    }

    @Override
    public void eliminar(int opcion, Banco obj) {
        repository.eliminar(opcion,obj.getCodigoBanco(), obj.getCuenta(),obj.getEntidadFinanciera(),obj.getNombreBanco(),obj.getNumeroCuenta(),obj.getTipoMoneda());
    }

    @Override
    public boolean codigoexiste(String codigo) {
        return repository.existsByCodigo(codigo);
    }

    @Override
    public boolean cuentaexiste(String cuenta) {
        return repository.existsByCuenta(cuenta);
    }

    @Override
    public boolean numeroCuenta(String numero) {
        return repository.existsByNumeroCuenta(numero);
    }

    @Override
    public boolean codigovalido(String codigo) {
        {
            return codigo.matches("\\d{4}");
        }
    }
}
