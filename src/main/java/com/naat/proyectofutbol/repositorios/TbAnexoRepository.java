package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.TbAnexo;
@Repository
public interface TbAnexoRepository extends JpaRepository<TbAnexo, String> {

}
