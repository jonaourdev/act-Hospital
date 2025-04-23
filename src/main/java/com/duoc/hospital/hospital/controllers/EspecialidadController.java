package com.duoc.hospital.hospital.controllers;

import com.duoc.hospital.hospital.models.Especialidad;
import com.duoc.hospital.hospital.services.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especialidades")
@Validated
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(especialidadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(especialidadService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        especialidadService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping
    public ResponseEntity<Especialidad> save(@Valid @RequestBody Especialidad especialidad) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(especialidadService.save(especialidad));
    }

}
