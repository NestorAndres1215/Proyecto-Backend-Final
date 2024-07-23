package com.naat.proyectofutbol.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbcupon")
public class TbCupon {

	@Id
	@Column(name = "cupon_Codigocupon")
	private String codigo; // PK
	private String cupon_Tipocupon;
	private String cupon_Descripcion;
	private LocalDate cupon_Fechainicio;
	private LocalDate cupon_Fechafin;
	private int cupon_Descuento;
	private String cupon_Condiciones;



	public TbCupon() {
	}

	public TbCupon(String codigo, String cupon_Tipocupon, String cupon_Descripcion, LocalDate cupon_Fechainicio, LocalDate cupon_Fechafin, int cupon_Descuento, String cupon_Condiciones) {
		this.codigo = codigo;
		this.cupon_Tipocupon = cupon_Tipocupon;
		this.cupon_Descripcion = cupon_Descripcion;
		this.cupon_Fechainicio = cupon_Fechainicio;
		this.cupon_Fechafin = cupon_Fechafin;
		this.cupon_Descuento = cupon_Descuento;
		this.cupon_Condiciones = cupon_Condiciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCupon_Tipocupon() {
		return cupon_Tipocupon;
	}

	public void setCupon_Tipocupon(String cupon_Tipocupon) {
		this.cupon_Tipocupon = cupon_Tipocupon;
	}

	public String getCupon_Descripcion() {
		return cupon_Descripcion;
	}

	public void setCupon_Descripcion(String cupon_Descripcion) {
		this.cupon_Descripcion = cupon_Descripcion;
	}

	public LocalDate getCupon_Fechainicio() {
		return cupon_Fechainicio;
	}

	public void setCupon_Fechainicio(LocalDate cupon_Fechainicio) {
		this.cupon_Fechainicio = cupon_Fechainicio;
	}

	public LocalDate getCupon_Fechafin() {
		return cupon_Fechafin;
	}

	public void setCupon_Fechafin(LocalDate cupon_Fechafin) {
		this.cupon_Fechafin = cupon_Fechafin;
	}

	public int getCupon_Descuento() {
		return cupon_Descuento;
	}

	public void setCupon_Descuento(int cupon_Descuento) {
		this.cupon_Descuento = cupon_Descuento;
	}

	public String getCupon_Condiciones() {
		return cupon_Condiciones;
	}

	public void setCupon_Condiciones(String cupon_Condiciones) {
		this.cupon_Condiciones = cupon_Condiciones;
	}
}
