package com.naat.proyectofutbol.repositorios;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naat.proyectofutbol.entidades.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	public Usuario findByUsername(String username);

	boolean existsByUsername(String username);
	boolean existsByUsernameAndPassword(String username, String password);
    boolean existsByCorreo(String correo);

    boolean existsByTelefono(String telefono);

	@Query(value = "SELECT MAX(ul_codigo) FROM Usuario", nativeQuery = true)
	String obtenerUltimoCodigo();

	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	List<Map<String, Object[]>> ListaUsuario(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);

	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	@Transactional
	@Modifying
	void ActualizarUsuario(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);

	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	@Transactional
	@Modifying
	void EliminarUsuario(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);

	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	List<Map<String, Object[]>> ListarPorCodigo(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);

	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	List<Map<String, Object[]>> ListarPorRol(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);
	
	@Query(value = "{call SP_Usuario(:opcion, :ul_codigo, :ul_usuario, :ul_contra, "
			+ ":ul_nombre, :ul_apellido, :ul_correo, :ul_direccion, :ul_telefono, :rol)}", nativeQuery = true)
	List<Map<String, Object[]>> ListarPorUsuario(@Param("opcion") int opcion, @Param("ul_codigo") String ul_codigo,
			@Param("ul_usuario") String ul_usuario, @Param("ul_contra") String ul_contra,
			@Param("ul_nombre") String ul_nombre, @Param("ul_apellido") String ul_apellido,
			@Param("ul_correo") String ul_correo, @Param("ul_direccion") String ul_direccion,
			@Param("ul_telefono") String ul_telefono, @Param("rol") String rol);
}