package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.dtos.RegistroEspecialidadDTO;
import com.duoc.hospital.hospital.dtos.RegistroEspecialidadViewDTO;
import com.duoc.hospital.hospital.models.RegistroEspecialidad;

import java.util.List;

public interface RegistroEspecialidadService {

    List<RegistroEspecialidad> findAll();
    RegistroEspecialidad findById(Long id);
    RegistroEspecialidad save(RegistroEspecialidadDTO registroEspecialidad);
    void deleteById(Long id);

}
