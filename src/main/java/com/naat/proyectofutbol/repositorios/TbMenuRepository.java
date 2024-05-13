package com.naat.proyectofutbol.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.TbMenu;


@Repository
public interface TbMenuRepository extends JpaRepository<TbMenu, Long> {
    List<TbMenu> findByMenuNivel(String menuNivel);
    List<TbMenu> findByMenuNombre(String menuNombre);
    List<TbMenu> findByMenuNivelAndMenuCategoria(String menuNivel, String menuCategoria);

    // Corregido el nombre del método
    // List<Menu> findByMenuNivelandcategoria(String menuNivel, String categoriaNivel);
}

