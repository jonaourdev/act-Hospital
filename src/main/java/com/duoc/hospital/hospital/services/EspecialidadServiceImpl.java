package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.exceptions.EspecialidadException;
import com.duoc.hospital.hospital.models.Especialidad;
import com.duoc.hospital.hospital.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspecialidadServiceImpl  implements EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Especialidad findById(Long id) {
        return especialidadRepository.findById(id).orElseThrow(
                () ->  new EspecialidadException("Especialidad con id "+id+" no existe")
        );
    }

    @Transactional
    @Override
    public Especialidad save(Especialidad especialidad) {
        if(especialidadRepository.findByTipoEspecialidadEquals(especialidad.getTipoEspecialidad()).isPresent()){
            throw new EspecialidadException("La especialidad "+especialidad.getTipoEspecialidad()+" ya existe");
        }
        return especialidadRepository.save(especialidad);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        especialidadRepository.deleteById(id);
    }





}
