package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.naat.proyectofutbol.entidades.Compania;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, String> {

    @Query(value = "{call SP_Compania(:opcion, :com_Codigo, :com_Nombre, :com_Logo, :com_Ruc, :com_Telefono, :com_Correo, " +
            ":com_Direccion, :com_Pais, :com_Sector, :com_FechaDeFundacion, :com_Descripcion)}", nativeQuery = true)
    List<Map<String, Object>> listar(@Param("opcion") int opcion,
                                     @Param("com_Codigo") String com_codigo,
                                     @Param("com_Nombre") String com_nombre,
                                     @Param("com_Logo") byte[] com_logo,
                                     @Param("com_Ruc") String com_ruc,
                                     @Param("com_Telefono") String com_telefono,
                                     @Param("com_Correo") String com_correo,
                                     @Param("com_Direccion") String com_direccion,
                                     @Param("com_Pais") String com_pais,
                                     @Param("com_Sector") String com_sector,
                                     @Param("com_FechaDeFundacion") LocalDate com_fecha_de_fundacion,
                                     @Param("com_Descripcion") String com_descripcion);
}
