package com.naat.proyectofutbol.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.TbCupon;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface TbCuponRepository extends JpaRepository<TbCupon, String>{


    @Query(value = "{call SP_TablaCupon(:opcion, :cupon_Codigocupon, :cupon_Tipocupon, :cupon_Descripcion, "
            + ":cupon_Fechainicio, :cupon_Fechafin, :cupon_Descuento, :cupon_Condiciones)}", nativeQuery = true)
    @Transactional
    @Modifying
    void registrar(@Param("opcion") int opcion,
                   @Param("cupon_Codigocupon") String codigo,
                   @Param("cupon_Tipocupon") String cupon_Tipocupon,
                   @Param("cupon_Descripcion") String cupon_Descripcion,
                   @Param("cupon_Fechainicio") LocalDate cupon_Fechainicio,
                   @Param("cupon_Fechafin") LocalDate cupon_Fechafin,
                   @Param("cupon_Descuento") int cupon_Descuento,
                   @Param("cupon_Condiciones") String cupon_Condiciones);

    @Query(value = "{call SP_TablaCupon(:opcion, :cupon_Codigocupon, :cupon_Tipocupon, :cupon_Descripcion, "
            + ":cupon_Fechainicio, :cupon_Fechafin, :cupon_Descuento, :cupon_Condiciones)}", nativeQuery = true)
    @Transactional
    @Modifying
    void actualizar(@Param("opcion") int opcion,
                   @Param("cupon_Codigocupon") String codigo,
                   @Param("cupon_Tipocupon") String cupon_Tipocupon,
                   @Param("cupon_Descripcion") String cupon_Descripcion,
                   @Param("cupon_Fechainicio") LocalDate cupon_Fechainicio,
                   @Param("cupon_Fechafin") LocalDate cupon_Fechafin,
                   @Param("cupon_Descuento") int cupon_Descuento,
                   @Param("cupon_Condiciones") String cupon_Condiciones);
    @Query(value = "{call SP_TablaCupon(:opcion, :cupon_Codigocupon, :cupon_Tipocupon, :cupon_Descripcion, "
            + ":cupon_Fechainicio, :cupon_Fechafin, :cupon_Descuento, :cupon_Condiciones)}", nativeQuery = true)
    @Transactional
    @Modifying
    void eliminar(@Param("opcion") int opcion,
                    @Param("cupon_Codigocupon") String codigo,
                    @Param("cupon_Tipocupon") String cupon_Tipocupon,
                    @Param("cupon_Descripcion") String cupon_Descripcion,
                    @Param("cupon_Fechainicio") LocalDate cupon_Fechainicio,
                    @Param("cupon_Fechafin") LocalDate cupon_Fechafin,
                    @Param("cupon_Descuento") int cupon_Descuento,
                    @Param("cupon_Condiciones") String cupon_Condiciones);

    boolean existsByCodigo(String codigo);

}
