package com.naat.proyectofutbol.controladores;

import com.naat.proyectofutbol.constrainst.AnexoMensaje;
import com.naat.proyectofutbol.constrainst.TablaGenerales;

import com.naat.proyectofutbol.entidades.Anexo;
import com.naat.proyectofutbol.servicios.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anexo")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }, allowedHeaders = "*")
public class AnexoController {

    @Autowired
    private AnexoService service;

    @GetMapping(value = { "/listaAnexo" })
    public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
        List<Map<String, Object>> lista;
        Anexo obj = new Anexo();

        try {
            lista = service.listar(0, obj);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
        }
    }
    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Anexo obj) {
        try {
            if (service.codigoandtipoexistente( obj.getCodigo(),obj.getTipo())) {
                return ResponseEntity.ok(AnexoMensaje.CODIGO_TIPO_EXISTENTE.getMensaje());
            }
            if(service.telefonoExistente(obj.getTelefono())){
                return  ResponseEntity.ok(AnexoMensaje.TELEFONO_EXISTENTE.getMensaje());
            }
            if(service.correoExistente(obj.getCorreo())){
                return  ResponseEntity.ok(AnexoMensaje.CORREO_EXISTENTE.getMensaje());
            }
            if(service.nombrecompletoExistente(obj.getNombrePrimario(),obj.getNombreSecundario(), obj.getApellidoPaterno(), obj.getApellidoMaterno())){
                return ResponseEntity.ok(AnexoMensaje.NOMBRE_COMPLETO.getMensaje());
            }
            if(service.numeroDocumentoExistente(obj.getNumeroDocumento())){
                return  ResponseEntity.ok(AnexoMensaje.NUMERO_DOCUMENTO_EXISTE.getMensaje());
            }
            if(!service.telefonoEsValido(obj.getTelefono())){
                return ResponseEntity.badRequest().body(AnexoMensaje.TELEFONO_INVALIDO.getMensaje());
            }
            service.registrar(1, obj);
            return ResponseEntity.ok(TablaGenerales.REGISTRO_GENERALES.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(TablaGenerales.ERROR_REGISTRO.getMensaje());
        }
    }

    @PutMapping ("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Anexo obj) {
        try {

            if(!service.telefonoEsValido(obj.getTelefono())){
                return ResponseEntity.badRequest().body(AnexoMensaje.TELEFONO_INVALIDO.getMensaje());
            }
            service.registrar(2, obj);
            return ResponseEntity.ok(TablaGenerales.REGISTRO_GENERALES.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(TablaGenerales.ERROR_REGISTRO.getMensaje());
        }
    }
    @DeleteMapping ("/eliminar")
    public ResponseEntity<String> eliminar(@RequestBody Anexo obj) {
        try {
            service.registrar(3, obj);
            return ResponseEntity.ok(TablaGenerales.REGISTRO_GENERALES.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(TablaGenerales.ERROR_REGISTRO.getMensaje());
        }
    }
}
