package com.naat.proyectofutbol.controladores;

import com.naat.proyectofutbol.constrainst.Cupon;
import com.naat.proyectofutbol.entidades.TbCupon;
import com.naat.proyectofutbol.servicios.TbCuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cupon")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }, allowedHeaders = "*")
public class TbCuponController {
    @Autowired
    private TbCuponService service;

    @GetMapping("/listar")
    public List<TbCupon> listarCupon() {
        return service.findAll();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registroNumeracion(@RequestBody TbCupon cupon) {
        try {
            LocalDate fechaInicio = cupon.getCupon_Fechainicio();
            LocalDate fechaFin = cupon.getCupon_Fechafin();

            // Validar las fechas
            if (fechaInicio.isAfter(fechaFin)) {
                return ResponseEntity.ok(Cupon.FECHA_MAYOR.getMensaje());
            }

            if (fechaFin.isBefore(fechaInicio)) {
                return ResponseEntity.ok(Cupon.FECHA_MENOR.getMensaje());
            }
            if (service.CuponEsValido(cupon.getCodigo())) {
                return ResponseEntity.ok(Cupon.CUPON_EXISTENTE.getMensaje());
            }
            service.RegistrarCupon(1,cupon);
            return ResponseEntity.ok(Cupon.REGISTRO_CUPON.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(Cupon.ERROR_REGISTRO.getMensaje());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody TbCupon cupon) {
        try {
            LocalDate fechaInicio = cupon.getCupon_Fechainicio();
            LocalDate fechaFin = cupon.getCupon_Fechafin();

            if (fechaInicio.isAfter(fechaFin)) {
                return ResponseEntity.ok(Cupon.FECHA_MAYOR.getMensaje());
            }
            if (fechaFin.isBefore(fechaInicio)) {
                return ResponseEntity.ok(Cupon.FECHA_MENOR.getMensaje());
            }
            service.RegistrarCupon(2,cupon);
            return ResponseEntity.ok(Cupon.ACTUALIZACION_CUPON.getMensaje());
        } catch (Exception e) {
            return ResponseEntity.ok(Cupon.ERROR_ACTUALIZACION.getMensaje());
        }
    }
}
