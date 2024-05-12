package com.naat.proyectofutbol.modelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tblogin")
public class TbLogin implements UserDetails {

	@Id
	private String us_codigo;
	 @Column(name = "us_usuario")
	    private String username;
	 @Column(name = "us_contra")
	private String password;
	private String us_rol;


	public TbLogin(String us_codigo, String username, String password, String us_rol) {
		super();
		this.us_codigo = us_codigo;
		this.username = username;
		this.password = password;
		this.us_rol = us_rol;
	}

	public TbLogin() {
		super();
	}

	public String getUs_codigo() {
		return us_codigo;
	}

	public void setUs_codigo(String us_codigo) {
		this.us_codigo = us_codigo;
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

	public String getUs_rol() {
		return us_rol;
	}

	public void setUs_rol(String us_rol) {
		this.us_rol = us_rol;
	}
	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        Set<Authority> autoridades = new HashSet<>();
	      
	            autoridades.add(new Authority(getUs_rol()));
	     
	        return autoridades;
	    }

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }


	


}
