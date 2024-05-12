package com.naat.proyectofutbol.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naat.proyectofutbol.entidades.Menu;
import com.naat.proyectofutbol.repositorios.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/menuPrimero")
    public ResponseEntity<List<Menu>> menuPrimero() {
        List<Menu> menuPrimero = menuRepository.findByMenuNivel("1");
        return ResponseEntity.ok(menuPrimero);
    }

    @GetMapping("/menuSegundo")
    public ResponseEntity<List<Menu>> menuSegundo() {
        List<Menu> menuSegundo = menuRepository.findByMenuNivel("2");
        return ResponseEntity.ok(menuSegundo);
    }
}