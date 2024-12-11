package com.naat.proyectofutbol.repositorios;

import com.naat.proyectofutbol.entidades.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, String> {
    @Query(value = "{call SP_ANEXO(:opcion, :anex_codigoanexo, :anex_tipoanexo, :anex_nombrepri, :anex_nombresecu, " +
            ":anex_apellidopat, :anex_apellidomat, :anex_tipodoc, :anex_numdoc, :anex_tipoper, :anex_direccion, :anex_area, " +
            ":anex_tipcargo, :anex_correo, :anex_telefono)}", nativeQuery = true)
    List<Map<String, Object>> ListaGenerales(@Param("opcion") int opcion,
                                             @Param("anex_codigoanexo") String anex_codigoanexo,
                                             @Param("anex_tipoanexo") String anex_tipoanexo,
                                             @Param("anex_nombrepri") String anex_nombrepri,
                                             @Param("anex_nombresecu") String anex_nombresecu,
                                             @Param("anex_apellidopat") String anex_apellidopat,
                                             @Param("anex_apellidomat") String anex_apellidomat,
                                             @Param("anex_tipodoc") String anex_tipodoc,
                                             @Param("anex_numdoc") String anex_numdoc,
                                             @Param("anex_tipoper") String anex_tipoper,
                                             @Param("anex_direccion") String anex_direccion,
                                             @Param("anex_area") String anex_area,
                                             @Param("anex_tipcargo") String anex_tipcargo,
                                             @Param("anex_correo") String anex_correo,
                                             @Param("anex_telefono") String anex_telefono);
    @Query(value = "{call SP_ANEXO(:opcion, :anex_codigoanexo, :anex_tipoanexo, :anex_nombrepri, :anex_nombresecu, " +
            ":anex_apellidopat, :anex_apellidomat, :anex_tipodoc, :anex_numdoc, :anex_tipoper, :anex_direccion, :anex_area, " +
            ":anex_tipcargo, :anex_correo, :anex_telefono)}", nativeQuery = true)
    @Transactional
    @Modifying
    void registrar(@Param("opcion") int opcion,
                    @Param("anex_codigoanexo") String anex_codigoanexo,
                    @Param("anex_tipoanexo") String anex_tipoanexo,
                    @Param("anex_nombrepri") String anex_nombrepri,
                    @Param("anex_nombresecu") String anex_nombresecu,
                    @Param("anex_apellidopat") String anex_apellidopat,
                    @Param("anex_apellidomat") String anex_apellidomat,
                    @Param("anex_tipodoc") String anex_tipodoc,
                    @Param("anex_numdoc") String anex_numdoc,
                    @Param("anex_tipoper") String anex_tipoper,
                    @Param("anex_direccion") String anex_direccion,
                    @Param("anex_area") String anex_area,
                    @Param("anex_tipcargo") String anex_tipcargo,
                    @Param("anex_correo") String anex_correo,
                    @Param("anex_telefono") String anex_telefono);

    @Query(value = "{call SP_ANEXO(:opcion, :anex_codigoanexo, :anex_tipoanexo, :anex_nombrepri, :anex_nombresecu, " +
            ":anex_apellidopat, :anex_apellidomat, :anex_tipodoc, :anex_numdoc, :anex_tipoper, :anex_direccion, :anex_area, " +
            ":anex_tipcargo, :anex_correo, :anex_telefono)}", nativeQuery = true)
    @Transactional
    @Modifying
    void actualizar(@Param("opcion") int opcion,
                   @Param("anex_codigoanexo") String anex_codigoanexo,
                   @Param("anex_tipoanexo") String anex_tipoanexo,
                   @Param("anex_nombrepri") String anex_nombrepri,
                   @Param("anex_nombresecu") String anex_nombresecu,
                   @Param("anex_apellidopat") String anex_apellidopat,
                   @Param("anex_apellidomat") String anex_apellidomat,
                   @Param("anex_tipodoc") String anex_tipodoc,
                   @Param("anex_numdoc") String anex_numdoc,
                   @Param("anex_tipoper") String anex_tipoper,
                   @Param("anex_direccion") String anex_direccion,
                   @Param("anex_area") String anex_area,
                   @Param("anex_tipcargo") String anex_tipcargo,
                   @Param("anex_correo") String anex_correo,
                   @Param("anex_telefono") String anex_telefono);
    @Query(value = "{call SP_ANEXO(:opcion, :anex_codigoanexo, :anex_tipoanexo, :anex_nombrepri, :anex_nombresecu, " +
            ":anex_apellidopat, :anex_apellidomat, :anex_tipodoc, :anex_numdoc, :anex_tipoper, :anex_direccion, :anex_area, " +
            ":anex_tipcargo, :anex_correo, :anex_telefono)}", nativeQuery = true)
    @Transactional
    @Modifying
    void eliminar(@Param("opcion") int opcion,
                   @Param("anex_codigoanexo") String anex_codigoanexo,
                   @Param("anex_tipoanexo") String anex_tipoanexo,
                   @Param("anex_nombrepri") String anex_nombrepri,
                   @Param("anex_nombresecu") String anex_nombresecu,
                   @Param("anex_apellidopat") String anex_apellidopat,
                   @Param("anex_apellidomat") String anex_apellidomat,
                   @Param("anex_tipodoc") String anex_tipodoc,
                   @Param("anex_numdoc") String anex_numdoc,
                   @Param("anex_tipoper") String anex_tipoper,
                   @Param("anex_direccion") String anex_direccion,
                   @Param("anex_area") String anex_area,
                   @Param("anex_tipcargo") String anex_tipcargo,
                   @Param("anex_correo") String anex_correo,
                   @Param("anex_telefono") String anex_telefono);
    boolean existsByNumeroDocumento(String numeroDocumento);
    boolean existsByTipoAndCodigo(String tipo, String codigo);
    boolean existsByTelefono(String telefono);
    boolean existsByCorreo(String correo);
    boolean existsByNombrePrimarioAndNombreSecundarioAndApellidoPaternoAndApellidoMaterno(
            String nombrePrimario,
            String nombreSecundario,
            String apellidoPaterno,
            String apellidoMaterno
    );
}
