package com.transporte.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @PostMapping("/new")
    public ResponseEntity<String> newViaje() {
        return new ResponseEntity<String>("Respuesta del servicio", HttpStatus.OK);
    }
}
