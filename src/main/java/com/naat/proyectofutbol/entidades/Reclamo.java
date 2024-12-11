package com.naat.proyectofutbol.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "reclamo")
public class Reclamo {

	@Id
	private String rec_codigo;
	private String rec_usuario;
	private String rec_correo;
	private String rec_descripcion;
	private String rec_asunto;
	private String rec_tiporeclamo;
	private String rec_fecha;
	private String rec_estado;
	private String rec_hora;
	@Lob
	private byte[] rec_archivo;
	
	public Reclamo(String rec_codigo, String rec_usuario, String rec_correo, String rec_descripcion,
				   String rec_asunto, String rec_tiporeclamo, String rec_fecha, String rec_estado, String rec_hora,
				   byte[] rec_archivo) {
		super();
		this.rec_codigo = rec_codigo;
		this.rec_usuario = rec_usuario;
		this.rec_correo = rec_correo;
		this.rec_descripcion = rec_descripcion;
		this.rec_asunto = rec_asunto;
		this.rec_tiporeclamo = rec_tiporeclamo;
		this.rec_fecha = rec_fecha;
		this.rec_estado = rec_estado;
		this.rec_hora = rec_hora;
		this.rec_archivo = rec_archivo;
	}

	public Reclamo() {
		super();
	}

	public String getRec_codigo() {
		return rec_codigo;
	}

	public void setRec_codigo(String rec_codigo) {
		this.rec_codigo = rec_codigo;
	}

	public String getRec_usuario() {
		return rec_usuario;
	}

	public void setRec_usuario(String rec_usuario) {
		this.rec_usuario = rec_usuario;
	}

	public String getRec_correo() {
		return rec_correo;
	}

	public void setRec_correo(String rec_correo) {
		this.rec_correo = rec_correo;
	}

	public String getRec_descripcion() {
		return rec_descripcion;
	}

	public void setRec_descripcion(String rec_descripcion) {
		this.rec_descripcion = rec_descripcion;
	}

	public String getRec_asunto() {
		return rec_asunto;
	}

	public void setRec_asunto(String rec_asunto) {
		this.rec_asunto = rec_asunto;
	}

	public String getRec_tiporeclamo() {
		return rec_tiporeclamo;
	}

	public void setRec_tiporeclamo(String rec_tiporeclamo) {
		this.rec_tiporeclamo = rec_tiporeclamo;
	}

	public String getRec_fecha() {
		return rec_fecha;
	}

	public void setRec_fecha(String rec_fecha) {
		this.rec_fecha = rec_fecha;
	}

	public String getRec_estado() {
		return rec_estado;
	}

	public void setRec_estado(String rec_estado) {
		this.rec_estado = rec_estado;
	}

	public String getRec_hora() {
		return rec_hora;
	}

	public void setRec_hora(String rec_hora) {
		this.rec_hora = rec_hora;
	}

	public byte[] getRec_archivo() {
		return rec_archivo;
	}

	public void setRec_archivo(byte[] rec_archivo) {
		this.rec_archivo = rec_archivo;
	}
	
	

}
