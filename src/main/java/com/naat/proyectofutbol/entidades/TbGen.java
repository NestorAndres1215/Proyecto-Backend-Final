package com.naat.proyectofutbol.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbgen")
public class TbGen {
	private static final long serialVersionUID = 1L;
	@Id

	private String tl_codigo;
	private String tl_clave;
	private String tl_descri1;
	private String tl_descri2;

	public TbGen() {
		super();
	}

	public TbGen(String tl_codigo, String tl_clave, String tl_descri1, String tl_descri2) {
		super();
		this.tl_codigo = tl_codigo;
		this.tl_clave = tl_clave;
		this.tl_descri1 = tl_descri1;
		this.tl_descri2 = tl_descri2;
	}

	public String getTl_codigo() {
		return tl_codigo;
	}

	public void setTl_codigo(String tl_codigo) {
		this.tl_codigo = tl_codigo;
	}

	public String getTl_clave() {
		return tl_clave;
	}

	public void setTl_clave(String tl_clave) {
		this.tl_clave = tl_clave;
	}

	public String getTl_descri1() {
		return tl_descri1;
	}

	public void setTl_descri1(String tl_descri1) {
		this.tl_descri1 = tl_descri1;
	}

	public String getTl_descri2() {
		return tl_descri2;
	}

	public void setTl_descri2(String tl_descri2) {
		this.tl_descri2 = tl_descri2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
