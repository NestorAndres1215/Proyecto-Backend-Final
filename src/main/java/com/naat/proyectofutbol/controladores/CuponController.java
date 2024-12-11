package com.naat.proyectofutbol.controladores;

import com.naat.proyectofutbol.constrainst.CuponMensaje;

import com.naat.proyectofutbol.entidades.Cupon;
import com.naat.proyectofutbol.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cupon")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }, allowedHeaders = "*")
public class CuponController {
    @Autowired
    private CuponService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> ListaGenerales() throws Exception {
        List<Map<String, Object>> lista;
        Cupon obj = new Cupon();

        try {
            lista = service.listar(0, obj);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            throw new Exception("Error HUR2006_B 1° + " + e.getMessage());
        }
    }


    @PostMapping("/registrar")
    public ResponseEntity<String> registroNumeracion(@RequestBody Cupon cupon) {
        try {
            LocalDate fechaInicio = cupon.getCp_Fechainicio();
            LocalDate fechaFin = cupon.getCp_Fechafin();

            // Validar las fechas
            if (fechaInicio.isAfter(fechaFin)) {
                return ResponseEntity.ok(CuponMensaje.FECHA_MAYOR.getMensaje());
            }

            if (fechaFin.isBefore(fechaInicio)) {
                return ResponseEntity.ok(CuponMensaje.FECHA_MENOR.getMensaje());
            }
            if (service.CuponEsValido(cupon.getCodigo())) {
                return ResponseEntity.ok(CuponMensaje.CUPON_EXISTENTE.getMensaje());
            }
            service.RegistrarCupon(1,cupon);
            return ResponseEntity.ok(CuponMensaje.REGISTRO_CUPON.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(CuponMensaje.ERROR_REGISTRO.getMensaje());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Cupon cupon) {
        try {
            LocalDate fechaInicio = cupon.getCp_Fechainicio();
            LocalDate fechaFin = cupon.getCp_Fechafin();

            if (fechaInicio.isAfter(fechaFin)) {
                return ResponseEntity.ok(CuponMensaje.FECHA_MAYOR.getMensaje());
            }
            if (fechaFin.isBefore(fechaInicio)) {
                return ResponseEntity.ok(CuponMensaje.FECHA_MENOR.getMensaje());
            }
            service.RegistrarCupon(2,cupon);
            return ResponseEntity.ok(CuponMensaje.ACTUALIZACION_CUPON.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(CuponMensaje.ERROR_ACTUALIZACION.getMensaje());
        }
    }
}
