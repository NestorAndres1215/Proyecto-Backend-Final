package com.naat.proyectofutbol.servicios;

import java.util.Set;
import com.naat.proyectofutbol.modelo.Usuario;
import com.naat.proyectofutbol.modelo.UsuarioRol;



public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
    Set<Usuario> obtenerMUsuario();
    
    
}
