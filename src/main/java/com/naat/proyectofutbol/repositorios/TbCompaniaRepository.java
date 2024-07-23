package com.naat.proyectofutbol.repositorios;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.naat.proyectofutbol.entidades.TbCompania;

@Repository
public interface TbCompaniaRepository extends JpaRepository<TbCompania, String> {

}
