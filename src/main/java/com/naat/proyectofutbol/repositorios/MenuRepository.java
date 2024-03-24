package com.naat.proyectofutbol.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuNivel(String menuNivel);
    List<Menu> findByMenuNombre(String menuNombre);
    List<Menu> findByMenuNivelAndMenuCategoria(String menuNivel, String menuCategoria);

    // Corregido el nombre del método
    // List<Menu> findByMenuNivelandcategoria(String menuNivel, String categoriaNivel);
}

