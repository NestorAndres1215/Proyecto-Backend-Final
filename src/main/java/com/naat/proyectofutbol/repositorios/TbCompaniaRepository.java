package com.naat.proyectofutbol.repositorios;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbCompania;
import com.naat.proyectofutbol.entidades.TbUsuario;


@Repository
public interface TbCompaniaRepository extends JpaRepository<TbCompania, String> {
    @Query(value = "{call SP_TablaCompania(:opcion, :com_codigo, :com_nombre, "
           + ":com_com_ruc, :com_telefono, :com_correo, :com_direccion, "
           + ":com_pais, :com_sector, :com_fecha_de_fundacion, :com_descripcion)}", nativeQuery = true)
    List<Map<String, Object[]>> listaCompania(
        @Param("opcion") int opcion,
        @Param("com_codigo") String comCodigo,
        @Param("com_nombre") String comNombre,
        @Param("com_com_ruc") String comComRuc,
        @Param("com_telefono") String comTelefono,
        @Param("com_correo") String comCorreo,
        @Param("com_direccion") String comDireccion,
        @Param("com_pais") String comPais,
        @Param("com_sector") String comSector,
        @Param("com_fecha_de_fundacion") Date comFechaDeFundacion,
        @Param("com_descripcion") String comDescripcion
    );
    
 
}

