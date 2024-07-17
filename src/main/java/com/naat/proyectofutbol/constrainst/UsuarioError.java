package com.naat.proyectofutbol.constrainst;

public enum UsuarioError {

    USUARIO_NO_AUTORIZADO("Usuario no autorizado"),
    USUARIO_NO_ENCONTRADO("Usuario no encontrado "),
    TOKEN_INSPIRADO("El token ha expirado"),
    USUARIO_EXISTENTE("Nombre de usuario ya existe"),
    TELEFONO_EXISTENTE("Numero de telefono ya existe"),
    CORREO_EXISTENTE("Correo Electronico ya existe"),
    TELEFONO_DIGITOS("Numero de telefono debe tener solo 9 digitos"),
    BIENVENIDO("BIENVENIDOS"),
    ERROR_USUARIO("Credenciales Invalidas"),
    REGISTRO_USUARIO("Error al Actualizar Usuario");


    
  
    private final String mensaje;

    UsuarioError(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
