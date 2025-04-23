package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.models.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadService {

    List<Especialidad> findAll();
    Especialidad findById(Long id);
    Especialidad save(Especialidad especialidad);
    void deleteById(Long id);


}
