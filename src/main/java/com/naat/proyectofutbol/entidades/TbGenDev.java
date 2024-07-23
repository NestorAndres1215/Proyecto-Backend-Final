package com.naat.proyectofutbol.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbgendev")
public class TbGenDev {

	@Id
	@Column(name = "tl_codigo")
	private String codigo;
	@Column(name = "tl_clave")
	private String clave;
	@Column(name = "tl_descri1")
	private String descripcion;
	private String tl_descri2;

	public TbGenDev() {
		super();
	}


	public TbGenDev(String codigo, String clave, String descripcion, String tl_descri2) {
		this.codigo = codigo;
		this.clave = clave;
		this.descripcion = descripcion;
		this.tl_descri2 = tl_descri2;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTl_descri2() {
		return tl_descri2;
	}

	public void setTl_descri2(String tl_descri2) {
		this.tl_descri2 = tl_descri2;
	}
}
