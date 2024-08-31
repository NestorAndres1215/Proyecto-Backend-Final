package com.naat.proyectofutbol.repositorios;

import com.naat.proyectofutbol.entidades.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BancoRepository extends JpaRepository<Banco,String> {
    @Query(value = "{call SP_BANCO(:opcion,:bl_codbco, :bl_cuenta, :bl_entfina, :bl_nombco, :bl_numcta, :bl_tipmon)}", nativeQuery = true)
    List<Map<String, Object>> listar(@Param("opcion") int opcion,
                                     @Param("bl_codbco") String bl_codbco,
                                     @Param("bl_cuenta") String bl_cuenta,
                                     @Param("bl_entfina") String bl_entfina,
                                     @Param("bl_nombco") String bl_nombco,
                                     @Param("bl_numcta") String bl_numcta,
                                     @Param("bl_tipmon") String bl_tipmon);


    @Query(value = "{call SP_BANCO(:opcion,:bl_codbco, :bl_cuenta, :bl_entfina, :bl_nombco, :bl_numcta, :bl_tipmon)}", nativeQuery = true)
    void registrar(@Param("opcion") int opcion,@Param("bl_codbco") String bl_codbco,
                   @Param("bl_cuenta") String bl_cuenta,
                   @Param("bl_entfina") String bl_entfina,
                   @Param("bl_nombco") String bl_nombco,
                   @Param("bl_numcta") String bl_numcta,
                   @Param("bl_tipmon") String bl_tipmon);

    @Query(value = "{call SP_BANCO(:opcion,:bl_codbco, :bl_cuenta, :bl_entfina, :bl_nombco, :bl_numcta, :bl_tipmon)}", nativeQuery = true)
    void actualizar(@Param("opcion") int opcion,@Param("bl_codbco") String bl_codbco,
                   @Param("bl_cuenta") String bl_cuenta,
                   @Param("bl_entfina") String bl_entfina,
                   @Param("bl_nombco") String bl_nombco,
                   @Param("bl_numcta") String bl_numcta,
                   @Param("bl_tipmon") String bl_tipmon);



    @Query(value = "{call SP_BANCO(:opcion,:bl_codbco, :bl_cuenta, :bl_entfina, :bl_nombco, :bl_numcta, :bl_tipmon)}", nativeQuery = true)
    void eliminar(@Param("opcion") int opcion,@Param("bl_codbco") String bl_codbco,
                   @Param("bl_cuenta") String bl_cuenta,
                   @Param("bl_entfina") String bl_entfina,
                   @Param("bl_nombco") String bl_nombco,
                   @Param("bl_numcta") String bl_numcta,
                   @Param("bl_tipmon") String bl_tipmon);


    boolean existsByCodigo(String codigo);
    boolean existsByCuenta(String cuenta);
    boolean existsByNumeroCuenta(String numeroCuenta);

}
