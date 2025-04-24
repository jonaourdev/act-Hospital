package com.duoc.hospital.hospital.controllers;

import com.duoc.hospital.hospital.dtos.AtencionCreacionDTO;
import com.duoc.hospital.hospital.dtos.AtencionViewDTO;
import com.duoc.hospital.hospital.models.Atencion;
import com.duoc.hospital.hospital.services.AtencionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
@Validated
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<AtencionViewDTO>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atencionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Atencion> save(@Valid @RequestBody AtencionCreacionDTO atencion){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(atencionService.save(atencion));
    }

}
