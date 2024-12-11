package com.naat.proyectofutbol.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banco")
public class Banco {
    @Id
    @Column(name = "bl_codbco")
    private String codigo;

    @Column(name = "bl_cuenta")
    private String cuenta;

    @Column(name = "bl_entfina")
    private String entidadFinanciera;

    @Column(name = "bl_nombco")
    private String nombreBanco;

    @Column(name = "bl_numcta")
    private String numeroCuenta;

    @Column(name = "bl_tipmon")
    private String tipoMoneda;

    public Banco() {
    }

    public Banco(String codigoBanco, String cuenta, String entidadFinanciera, String nombreBanco, String numeroCuenta, String tipoMoneda) {
        this.codigo= codigoBanco;
        this.cuenta = cuenta;
        this.entidadFinanciera = entidadFinanciera;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoMoneda = tipoMoneda;
    }


    public String getCodigoBanco() {
        return codigo;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigo = codigoBanco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getEntidadFinanciera() {
        return entidadFinanciera;
    }

    public void setEntidadFinanciera(String entidadFinanciera) {
        this.entidadFinanciera = entidadFinanciera;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
}
