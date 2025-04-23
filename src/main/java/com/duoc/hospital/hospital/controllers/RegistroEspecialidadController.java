package com.duoc.hospital.hospital.controllers;

import com.duoc.hospital.hospital.dtos.RegistroEspecialidadDTO;
import com.duoc.hospital.hospital.dtos.RegistroEspecialidadViewDTO;
import com.duoc.hospital.hospital.models.RegistroEspecialidad;
import com.duoc.hospital.hospital.repositories.RegistroEspecialidadRepository;
import com.duoc.hospital.hospital.services.RegistroEspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registro-especialidades")
@Validated
public class RegistroEspecialidadController {

    @Autowired
    private RegistroEspecialidadService registroEspecialidadService;

    @GetMapping
    public ResponseEntity<List<RegistroEspecialidad>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registroEspecialidadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroEspecialidad> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registroEspecialidadService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        registroEspecialidadService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping
    public ResponseEntity<RegistroEspecialidad> save(@Valid @RequestBody RegistroEspecialidadDTO registroEspecialidad) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registroEspecialidadService.save(registroEspecialidad));
    }


}
