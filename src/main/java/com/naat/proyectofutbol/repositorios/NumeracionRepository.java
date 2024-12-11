package com.naat.proyectofutbol.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.Numeracion;

import javax.transaction.Transactional;

@Repository
public interface NumeracionRepository extends JpaRepository<Numeracion, String> {
	@Query(value = "{call SP_Numeracion(:opcion, :num_codigo, :num_descripcion, "
			+ ":num_cantidad,:num_fecha)}", nativeQuery = true)
	List<Map<String, Object>> listar(@Param("opcion") int opcion, @Param("num_codigo") String num_codigo,
									 @Param("num_descripcion") String num_descripcion, @Param("num_cantidad") String num_cantidad,
									 @Param("num_fecha") LocalDate num_fecha);
	@Query(value = "{call SP_Numeracion(:opcion, :num_codigo, :num_descripcion, "
			+ ":num_cantidad,:num_fecha)}", nativeQuery = true)
	@Transactional
	@Modifying
	void registrar(@Param("opcion") int opcion, @Param("num_codigo") String num_codigo,
			@Param("num_descripcion") String num_descripcion, @Param("num_cantidad") String num_cantidad,
			@Param("num_fecha") LocalDate num_fecha);
}
