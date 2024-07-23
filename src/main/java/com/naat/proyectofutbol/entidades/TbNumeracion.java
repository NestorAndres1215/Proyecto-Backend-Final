package com.naat.proyectofutbol.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbnumeracion")
public class TbNumeracion {
	@Id
	private String num_codigo;
	private String num_descripcion;
	private String num_cantidad;

	//@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	//@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate num_fecha;

	public TbNumeracion() {
	}

	public TbNumeracion(String num_codigo, String num_descripcion, String num_cantidad, LocalDate num_fecha) {
		this.num_codigo = num_codigo;
		this.num_descripcion = num_descripcion;
		this.num_cantidad = num_cantidad;
		this.num_fecha = num_fecha;
	}

	public String getNum_codigo() {
		return num_codigo;
	}

	public void setNum_codigo(String num_codigo) {
		this.num_codigo = num_codigo;
	}

	public String getNum_descripcion() {
		return num_descripcion;
	}

	public void setNum_descripcion(String num_descripcion) {
		this.num_descripcion = num_descripcion;
	}

	public String getNum_cantidad() {
		return num_cantidad;
	}

	public void setNum_cantidad(String num_cantidad) {
		this.num_cantidad = num_cantidad;
	}

	public LocalDate getNum_fecha() {
		return num_fecha;
	}

	public void setNum_fecha(LocalDate num_fecha) {
		this.num_fecha = num_fecha;
	}
}
