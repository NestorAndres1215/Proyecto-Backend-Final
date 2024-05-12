package com.naat.proyectofutbol.repositorios;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naat.proyectofutbol.entidades.TbUsuario;



public interface UsuarioRepository extends JpaRepository<TbUsuario,String> {

    public TbUsuario findByUsername(String username);
 

}