package com.naat.proyectofutbol.constrainst;

public enum TablaGenerales {

    ERROR_REGISTRO("HUBO UN ERROR EN EL REGISTRO DE TABLA GENERALES"),
    ERROR_DETALLE("HUBO UN ERROR EN EL REGISTRO DE DETALLE DE TABLA GENERALES"),
    ACTUALIZAR_DETALLE("SE ACTUALIZO DETALLE DE TABLA GENERALES CORRETAMENTE "),
    ERROR_ACTUALZIACION("HUBO UN ERROR EN LA ACTUALIZACION  DE TABLA GENERALES"),
    ERROR_ACTUALZIACION_DETALLES("HUBO UN ERROR EN LA ACTUALIZACION   DE DETALLE DE TABLA GENERALES"),

    ACTUALIZAR("SE ACTUALIZO TABLA GENERALES CORRETAMENTE "),
    CODIGO_EXISTENTE("EL CODIGO YA EXISTE"),
    DESCRIPCION_EXISTE("NOMBRE DE LA DESCRIPCION YA EXISTE"),
    CLAVE_EXISTENTE("CLAVE DE TABLA GENERAL YA EXISTE"),
    CLAVE_CODIGO_EXISTENTE("CLAVE Y CODIGO YA EXISTE EN LA TABLA DE DETALLE"),
    REGISTRO_GENERALES("SE REGISTRO TABLA GENERAL CORRECTAMENTE"),
    ELIMINAR_TOTAL("SE ELIMINO CORRECTAMENTE"),
    ERROR_ELIMINACION("HUBO UN ERROR EN LA ELIMINACION"),
    REGISTRO_DETALLES("SE REGISTRO DETALLE DE TABLA GENERAL CORRECTAMENTE");

        private final String mensaje;

         TablaGenerales(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

}
