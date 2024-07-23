package com.naat.proyectofutbol.repositorios;

import com.naat.proyectofutbol.entidades.TbGenDev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface TbGenDevRepository extends JpaRepository<TbGenDev, String> {

    @Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
    List<Map<String, Object>> ListaGeneralesDetalle(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
                                                    @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
                                                    @Param("tl_descri2") String tl_descri2);
    @Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
    @Transactional
    @Modifying
    void RegistrarTablaGeneralDetalle(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
                                      @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
                                      @Param("tl_descri2") String tl_descri2);

    @Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
    @Transactional
    @Modifying
    void Actualizar(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
                                      @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
                                      @Param("tl_descri2") String tl_descri2);
    @Query(value = "{call SP_TablaGenerales(:opcion, :tl_codigo, :tl_clave, :tl_descri1, :tl_descri2)}", nativeQuery = true)
    @Transactional
    @Modifying
    void Eliminar(@Param("opcion") int opcion, @Param("tl_codigo") String codigo,
                    @Param("tl_clave") String clave, @Param("tl_descri1") String descripcion,
                    @Param("tl_descri2") String tl_descri2);
    boolean existsByClaveAndCodigo(String clave, String codigo);
    boolean existsByDescripcion(String Descripcion);
}
