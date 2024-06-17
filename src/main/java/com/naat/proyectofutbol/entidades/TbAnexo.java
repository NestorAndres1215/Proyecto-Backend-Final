package com.naat.proyectofutbol.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbanexo")
public class TbAnexo {
	@Id
	private String anex_codigoanexo;
	private String anex_tipoanexo;
	private String anex_nombrepri;
	private String anex_nombresecu;
	private String anex_apellidopat;
	private String anex_apellidomat;
	private String anex_tipodoc;
	private String anex_numdoc;
	private String anex_tipoper;
	private String anex_direccion;
	private String anex_area;
	private String anex_tipcargo;
	private String anex_correo;
	private String anex_telefono;

	public TbAnexo(String anex_codigoanexo, String anex_tipoanexo, String anex_nombrepri, String anex_nombresecu,
			String anex_apellidopat, String anex_apellidomat, String anex_tipodoc, String anex_numdoc,
			String anex_tipoper, String anex_direccion, String anex_area, String anex_tipcargo, String anex_correo,
			String anex_telefono) {
		super();
		this.anex_codigoanexo = anex_codigoanexo;
		this.anex_tipoanexo = anex_tipoanexo;
		this.anex_nombrepri = anex_nombrepri;
		this.anex_nombresecu = anex_nombresecu;
		this.anex_apellidopat = anex_apellidopat;
		this.anex_apellidomat = anex_apellidomat;
		this.anex_tipodoc = anex_tipodoc;
		this.anex_numdoc = anex_numdoc;
		this.anex_tipoper = anex_tipoper;
		this.anex_direccion = anex_direccion;
		this.anex_area = anex_area;
		this.anex_tipcargo = anex_tipcargo;
		this.anex_correo = anex_correo;
		this.anex_telefono = anex_telefono;
	}

	public TbAnexo() {
		super();
	}

	public String getAnex_codigoanexo() {
		return anex_codigoanexo;
	}

	public void setAnex_codigoanexo(String anex_codigoanexo) {
		this.anex_codigoanexo = anex_codigoanexo;
	}

	public String getAnex_tipoanexo() {
		return anex_tipoanexo;
	}

	public void setAnex_tipoanexo(String anex_tipoanexo) {
		this.anex_tipoanexo = anex_tipoanexo;
	}

	public String getAnex_nombrepri() {
		return anex_nombrepri;
	}

	public void setAnex_nombrepri(String anex_nombrepri) {
		this.anex_nombrepri = anex_nombrepri;
	}

	public String getAnex_nombresecu() {
		return anex_nombresecu;
	}

	public void setAnex_nombresecu(String anex_nombresecu) {
		this.anex_nombresecu = anex_nombresecu;
	}

	public String getAnex_apellidopat() {
		return anex_apellidopat;
	}

	public void setAnex_apellidopat(String anex_apellidopat) {
		this.anex_apellidopat = anex_apellidopat;
	}

	public String getAnex_apellidomat() {
		return anex_apellidomat;
	}

	public void setAnex_apellidomat(String anex_apellidomat) {
		this.anex_apellidomat = anex_apellidomat;
	}

	public String getAnex_tipodoc() {
		return anex_tipodoc;
	}

	public void setAnex_tipodoc(String anex_tipodoc) {
		this.anex_tipodoc = anex_tipodoc;
	}

	public String getAnex_numdoc() {
		return anex_numdoc;
	}

	public void setAnex_numdoc(String anex_numdoc) {
		this.anex_numdoc = anex_numdoc;
	}

	public String getAnex_tipoper() {
		return anex_tipoper;
	}

	public void setAnex_tipoper(String anex_tipoper) {
		this.anex_tipoper = anex_tipoper;
	}

	public String getAnex_direccion() {
		return anex_direccion;
	}

	public void setAnex_direccion(String anex_direccion) {
		this.anex_direccion = anex_direccion;
	}

	public String getAnex_area() {
		return anex_area;
	}

	public void setAnex_area(String anex_area) {
		this.anex_area = anex_area;
	}

	public String getAnex_tipcargo() {
		return anex_tipcargo;
	}

	public void setAnex_tipcargo(String anex_tipcargo) {
		this.anex_tipcargo = anex_tipcargo;
	}

	public String getAnex_correo() {
		return anex_correo;
	}

	public void setAnex_correo(String anex_correo) {
		this.anex_correo = anex_correo;
	}

	public String getAnex_telefono() {
		return anex_telefono;
	}

	public void setAnex_telefono(String anex_telefono) {
		this.anex_telefono = anex_telefono;
	}

}
