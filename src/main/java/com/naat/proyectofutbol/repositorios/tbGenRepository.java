package com.naat.proyectofutbol.repositorios;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.TbGen;

@Repository
public interface tbGenRepository extends JpaRepository<TbGen, String> {

	@Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2,)}", nativeQuery = true)
	List<Map<String, Object[]>> ListaGenerales(@Param("opcion") int opcion, @Param("tl_codigo") String tl_codigo,
			@Param("tl_clave") String tl_clave, @Param("tl_descri1") String tl_descri1,
			@Param("tl_descri2") String tl_descri2);

	@Query(value = "{call SP_TablaGenerales(:option, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2,)}", nativeQuery = true)
	List<Map<String, Object[]>> ListaGeneralesDetalle(@Param("opcion") int opcion, @Param("tl_codigo") String tl_codigo,
			@Param("tl_clave") String tl_clave, @Param("tl_descri1") String tl_descri1,
			@Param("tl_descri2") String tl_descri2);

}
