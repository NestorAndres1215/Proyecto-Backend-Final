package com.naat.proyectofutbol.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbcupon")
public class TbCupon {

	@Id
	private String cupon_Codigocupon; // PK
	private String cupon_Tipocupon;
	private String cupon_Descripcion;
	private String cupon_Fechainicio;
	private String cupon_Fechafin;
	private String cupon_Descuento;
	private String cupon_Condiciones;

	public TbCupon(String cupon_Codigocupon, String cupon_Tipocupon, String cupon_Descripcion, String cupon_Fechainicio,
			String cupon_Fechafin, String cupon_Descuento, String cupon_Condiciones) {
		super();
		this.cupon_Codigocupon = cupon_Codigocupon;
		this.cupon_Tipocupon = cupon_Tipocupon;
		this.cupon_Descripcion = cupon_Descripcion;
		this.cupon_Fechainicio = cupon_Fechainicio;
		this.cupon_Fechafin = cupon_Fechafin;
		this.cupon_Descuento = cupon_Descuento;
		this.cupon_Condiciones = cupon_Condiciones;
	}

	public TbCupon() {
		super();
	}

	public String getCupon_Codigocupon() {
		return cupon_Codigocupon;
	}

	public void setCupon_Codigocupon(String cupon_Codigocupon) {
		this.cupon_Codigocupon = cupon_Codigocupon;
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

	public String getCupon_Fechainicio() {
		return cupon_Fechainicio;
	}

	public void setCupon_Fechainicio(String cupon_Fechainicio) {
		this.cupon_Fechainicio = cupon_Fechainicio;
	}

	public String getCupon_Fechafin() {
		return cupon_Fechafin;
	}

	public void setCupon_Fechafin(String cupon_Fechafin) {
		this.cupon_Fechafin = cupon_Fechafin;
	}

	public String getCupon_Descuento() {
		return cupon_Descuento;
	}

	public void setCupon_Descuento(String cupon_Descuento) {
		this.cupon_Descuento = cupon_Descuento;
	}

	public String getCupon_Condiciones() {
		return cupon_Condiciones;
	}

	public void setCupon_Condiciones(String cupon_Condiciones) {
		this.cupon_Condiciones = cupon_Condiciones;
	}

}
