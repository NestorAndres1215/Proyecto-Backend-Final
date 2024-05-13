package com.naat.proyectofutbol.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class TbMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	private String menuNivel;
	private String menuNombre;
	private String menuTipo;
	private String menuCodigo;
	private String menuIcono;
	private String menuCategoria;
	private String menuRuta;
	public TbMenu(String menuNivel, String menuNombre, String menuTipo, String menuCodigo, String menuIcono,
			String menuCategoria, String menuRuta) {
		super();
		this.menuNivel = menuNivel;
		this.menuNombre = menuNombre;
		this.menuTipo = menuTipo;
		this.menuCodigo = menuCodigo;
		this.menuIcono = menuIcono;
		this.menuCategoria = menuCategoria;
		this.menuRuta = menuRuta;
	}
	public TbMenu() {
		super();
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuNivel() {
		return menuNivel;
	}
	public void setMenuNivel(String menuNivel) {
		this.menuNivel = menuNivel;
	}
	public String getMenuNombre() {
		return menuNombre;
	}
	public void setMenuNombre(String menuNombre) {
		this.menuNombre = menuNombre;
	}
	public String getMenuTipo() {
		return menuTipo;
	}
	public void setMenuTipo(String menuTipo) {
		this.menuTipo = menuTipo;
	}
	public String getMenuCodigo() {
		return menuCodigo;
	}
	public void setMenuCodigo(String menuCodigo) {
		this.menuCodigo = menuCodigo;
	}
	public String getMenuIcono() {
		return menuIcono;
	}
	public void setMenuIcono(String menuIcono) {
		this.menuIcono = menuIcono;
	}
	public String getMenuCategoria() {
		return menuCategoria;
	}
	public void setMenuCategoria(String menuCategoria) {
		this.menuCategoria = menuCategoria;
	}
	public String getMenuRuta() {
		return menuRuta;
	}
	public void setMenuRuta(String menuRuta) {
		this.menuRuta = menuRuta;
	}
	
	
	
}
