package com.naat.proyectofutbol.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cupon")
public class Cupon {

	@Id
	@Column(name = "cp_Codigocupon")
	private String codigo;
	private String cp_Tipocupon;
	private String cp_Descripcion;
	private LocalDate cp_Fechainicio;
	private LocalDate cp_Fechafin;
	private int cp_Descuento;
	private String cp_Condiciones;



	public Cupon() {
	}

	public Cupon(String codigo, String cp_Tipocupon, String cp_Descripcion, LocalDate cp_Fechainicio, LocalDate cp_Fechafin, int cp_Descuento, String cp_Condiciones) {
		this.codigo = codigo;
		this.cp_Tipocupon = cp_Tipocupon;
		this.cp_Descripcion = cp_Descripcion;
		this.cp_Fechainicio = cp_Fechainicio;
		this.cp_Fechafin = cp_Fechafin;
		this.cp_Descuento = cp_Descuento;
		this.cp_Condiciones = cp_Condiciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCp_Tipocupon() {
		return cp_Tipocupon;
	}

	public void setCp_Tipocupon(String cp_Tipocupon) {
		this.cp_Tipocupon = cp_Tipocupon;
	}

	public String getCp_Descripcion() {
		return cp_Descripcion;
	}

	public void setCp_Descripcion(String cp_Descripcion) {
		this.cp_Descripcion = cp_Descripcion;
	}

	public LocalDate getCp_Fechainicio() {
		return cp_Fechainicio;
	}

	public void setCp_Fechainicio(LocalDate cp_Fechainicio) {
		this.cp_Fechainicio = cp_Fechainicio;
	}

	public LocalDate getCp_Fechafin() {
		return cp_Fechafin;
	}

	public void setCp_Fechafin(LocalDate cp_Fechafin) {
		this.cp_Fechafin = cp_Fechafin;
	}

	public int getCp_Descuento() {
		return cp_Descuento;
	}

	public void setCp_Descuento(int cp_Descuento) {
		this.cp_Descuento = cp_Descuento;
	}

	public String getCp_Condiciones() {
		return cp_Condiciones;
	}

	public void setCp_Condiciones(String cp_Condiciones) {
		this.cp_Condiciones = cp_Condiciones;
	}
}
