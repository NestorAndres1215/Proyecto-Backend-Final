package com.naat.proyectofutbol.repositorios;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.TbGen;

import javax.transaction.Transactional;

@Repository
public interface TbGenRepository extends JpaRepository<TbGen, String> {

	@Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
	List<Map<String, Object>> ListaGenerales(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
											 @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
											 @Param("tl_descri2") String tl_descri2);

	@Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
	@Transactional
	@Modifying
	void RegistrarTablaGeneral(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
							   @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
							   @Param("tl_descri2") String tl_descri2);

	@Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
	@Transactional
	@Modifying
	void ActualizarTablaGeneral(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
							   @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
							   @Param("tl_descri2") String tl_descri2);

	@Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
	@Transactional
	@Modifying
	void EliminarTablaGeneral(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
								@Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
								@Param("tl_descri2") String tl_descri2);

	boolean existsByCodigo(String codigo);
	boolean existsByClave(String clave);
	boolean existsByDescripcion(String Descripcion);
}
