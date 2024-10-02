package com.naat.proyectofutbol.response;

import com.naat.proyectofutbol.entidades.Usuario;
import com.naat.proyectofutbol.modelo.Login;

public class UsuarioLoginResponse {
    private Usuario usuario;
    private Login login;

    public UsuarioLoginResponse(Usuario usuario, Login login) {
        this.usuario = usuario;
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}