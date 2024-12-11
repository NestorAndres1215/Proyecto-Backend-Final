package com.naat.proyectofutbol.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anexo")
public class Anexo {
	@Id
	@Column(name = "al_codigoanexo")
	private String codigo;

	@Column(name = "al_tipoanexo")
	private String tipo;

	@Column(name = "al_nombrepri")
	private String nombrePrimario;
	@Column(name = "al_nombresecu")
	private String nombreSecundario;

	@Column(name = "al_apellidopat")
	private String apellidoPaterno;

	@Column(name = "al_apellidomat")
	private String apellidoMaterno;
	@Column(name = "al_tipodoc")
	private String tipoDocumento;

	@Column(name = "al_numdoc")
	private String numeroDocumento;
	@Column(name = "al_tipoper")
	private String tipoPersona;
	private String al_direccion;
	private String al_area;
	private String al_tipcargo;
	@Column(name = "al_correo")
	private String correo;

	@Column(name = "al_telefono")
	private String telefono;

	public Anexo(String codigo, String tipo, String nombrePrimario, String nombreSecundario, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroDocumento, String tipoPersona, String al_direccion, String al_area, String al_tipcargo, String correo, String telefono) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.nombrePrimario = nombrePrimario;
		this.nombreSecundario = nombreSecundario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.tipoPersona = tipoPersona;
		this.al_direccion = al_direccion;
		this.al_area = al_area;
		this.al_tipcargo = al_tipcargo;
		this.correo = correo;
		this.telefono = telefono;
	}

	public Anexo() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombrePrimario() {
		return nombrePrimario;
	}

	public void setNombrePrimario(String nombrePrimario) {
		this.nombrePrimario = nombrePrimario;
	}

	public String getNombreSecundario() {
		return nombreSecundario;
	}

	public void setNombreSecundario(String nombreSecundario) {
		this.nombreSecundario = nombreSecundario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getAl_direccion() {
		return al_direccion;
	}

	public void setAl_direccion(String al_direccion) {
		this.al_direccion = al_direccion;
	}

	public String getAl_area() {
		return al_area;
	}

	public void setAl_area(String al_area) {
		this.al_area = al_area;
	}

	public String getAl_tipcargo() {
		return al_tipcargo;
	}

	public void setAl_tipcargo(String al_tipcargo) {
		this.al_tipcargo = al_tipcargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}