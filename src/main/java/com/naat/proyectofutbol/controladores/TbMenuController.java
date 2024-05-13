package com.naat.proyectofutbol.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naat.proyectofutbol.entidades.TbMenu;
import com.naat.proyectofutbol.repositorios.TbMenuRepository;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class TbMenuController {

    @Autowired
    private TbMenuRepository menuRepository;

    @GetMapping("/menuPrimero")
    public ResponseEntity<List<TbMenu>> menuPrimero() {
        List<TbMenu> menuPrimero = menuRepository.findByMenuNivel("1");
        return ResponseEntity.ok(menuPrimero);
    }

    @GetMapping("/menuSegundo")
    public ResponseEntity<List<TbMenu>> menuSegundo() {
        List<TbMenu> menuSegundo = menuRepository.findByMenuNivel("2");
        return ResponseEntity.ok(menuSegundo);
    }
}