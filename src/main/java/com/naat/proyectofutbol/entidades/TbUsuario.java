package com.naat.proyectofutbol.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;




@Entity
@Table(name = "tbusuario")
public class TbUsuario  {


	@Id
	
	private String ul_codigo;
	 @Column(name = "ul_usuario")
	    private String username;
	 @Column(name = "ul_contra")
	private String password;
	private String ul_nombre;
	private String ul_apellido;
	@Lob
	private byte[] ul_perfil;
	private String ul_correo;
	private String ul_direccion;
	private String ul_telefono;
	private String ul_rol;
	private boolean ul_estado = true;
	public TbUsuario(String ul_codigo, String username, String password, String ul_nombre, String ul_apellido,
			String ul_email, String ul_correo, String ul_direccion, String ul_telefono, String ul_rol,
			boolean ul_estado) {
		super();
		this.ul_codigo = ul_codigo;
		this.username = username;
		this.password = password;
		this.ul_nombre = ul_nombre;
		this.ul_apellido = ul_apellido;
	
		this.ul_correo = ul_correo;
		this.ul_direccion = ul_direccion;
		this.ul_telefono = ul_telefono;
		this.ul_rol = ul_rol;
		this.ul_estado = ul_estado;
	}
	public TbUsuario() {
		super();
	}
	public String getUl_codigo() {
		return ul_codigo;
	}
	public void setUl_codigo(String ul_codigo) {
		this.ul_codigo = ul_codigo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUl_nombre() {
		return ul_nombre;
	}
	public void setUl_nombre(String ul_nombre) {
		this.ul_nombre = ul_nombre;
	}
	public String getUl_apellido() {
		return ul_apellido;
	}
	public void setUl_apellido(String ul_apellido) {
		this.ul_apellido = ul_apellido;
	}

	public String getUl_correo() {
		return ul_correo;
	}
	public void setUl_correo(String ul_correo) {
		this.ul_correo = ul_correo;
	}
	public String getUl_direccion() {
		return ul_direccion;
	}
	public void setUl_direccion(String ul_direccion) {
		this.ul_direccion = ul_direccion;
	}
	public String getUl_telefono() {
		return ul_telefono;
	}
	public void setUl_telefono(String ul_telefono) {
		this.ul_telefono = ul_telefono;
	}
	public String getUl_rol() {
		return ul_rol;
	}
	public void setUl_rol(String ul_rol) {
		this.ul_rol = ul_rol;
	}
	public boolean isUl_estado() {
		return ul_estado;
	}
	public void setUl_estado(boolean ul_estado) {
		this.ul_estado = ul_estado;
	}
	public byte[] getUl_perfil() {
		return ul_perfil;
	}
	public void setUl_perfil(byte[] ul_perfil) {
		this.ul_perfil = ul_perfil;
	}
	

   
}
