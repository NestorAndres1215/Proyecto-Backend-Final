package com.naat.proyectofutbol.constrainst;

public enum Mensaje {

    ERROR_INTERNO("Ocurrió un error interno en el servidor. Por favor, inténtalo de nuevo más tarde"),
    REGISTRO("Se Registro Correctamente"),
    TOKEN_INVALIDO("Token Invalido"),
    ACTUALIZACION("Se Actualizo Correctamente"),
    ELIMINACION("Se Elimino Correctamente"),
    REGISTRO_ERROR("Hubo un error nose pudo  registrar "),
    ACTUALIZACION_ERROR("Hubo un error no se pudo actualizar "),
    ELIMINACION_ERROR("Hubo un errror nose pudo eliminar ")
    ;

    private final String mensaje;

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
