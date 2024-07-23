package com.naat.proyectofutbol.entidades;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "tbcompania")
public class TbCompania {
	private static final long serialVersionUID = 1L;
	@Id

	private String com_codigo;
	private String com_nombre;
	@Lob
	private byte[] com_logo;
	private String com_ruc;
	private String com_telefono;
	private String com_correo;
	private String com_direccion;
	private String com_pais;
	private String com_sector;
	 @Temporal(TemporalType.TIMESTAMP)
	private Date com_fecha_de_fundacion;
	private String com_descripcion;
	public TbCompania(String com_codigo, String com_nombre, byte[] com_logo, String com_ruc, String com_telefono,
			String com_correo, String com_direccion, String com_pais, String com_sector, Date com_fecha_de_fundacion,
			String com_descripcion) {
		super();
		this.com_codigo = com_codigo;
		this.com_nombre = com_nombre;
		this.com_logo = com_logo;
		this.com_ruc = com_ruc;
		this.com_telefono = com_telefono;
		this.com_correo = com_correo;
		this.com_direccion = com_direccion;
		this.com_pais = com_pais;
		this.com_sector = com_sector;
		this.com_fecha_de_fundacion = com_fecha_de_fundacion;
		this.com_descripcion = com_descripcion;
	}
	public TbCompania() {
		super();
	}
	public String getCom_codigo() {
		return com_codigo;
	}
	public void setCom_codigo(String com_codigo) {
		this.com_codigo = com_codigo;
	}
	public String getCom_nombre() {
		return com_nombre;
	}
	public void setCom_nombre(String com_nombre) {
		this.com_nombre = com_nombre;
	}
	public byte[] getCom_logo() {
		return com_logo;
	}
	public void setCom_logo(byte[] com_logo) {
		this.com_logo = com_logo;
	}
	public String getCom_ruc() {
		return com_ruc;
	}
	public void setCom_ruc(String com_ruc) {
		this.com_ruc = com_ruc;
	}
	public String getCom_telefono() {
		return com_telefono;
	}
	public void setCom_telefono(String com_telefono) {
		this.com_telefono = com_telefono;
	}
	public String getCom_correo() {
		return com_correo;
	}
	public void setCom_correo(String com_correo) {
		this.com_correo = com_correo;
	}
	public String getCom_direccion() {
		return com_direccion;
	}
	public void setCom_direccion(String com_direccion) {
		this.com_direccion = com_direccion;
	}
	public String getCom_pais() {
		return com_pais;
	}
	public void setCom_pais(String com_pais) {
		this.com_pais = com_pais;
	}
	public String getCom_sector() {
		return com_sector;
	}
	public void setCom_sector(String com_sector) {
		this.com_sector = com_sector;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	public Date getCom_fecha_de_fundacion() {
		return com_fecha_de_fundacion;
	}
	public void setCom_fecha_de_fundacion(Date com_fecha_de_fundacion) {
		this.com_fecha_de_fundacion = com_fecha_de_fundacion;
	}
	public String getCom_descripcion() {
		return com_descripcion;
	}
	public void setCom_descripcion(String com_descripcion) {
		this.com_descripcion = com_descripcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
