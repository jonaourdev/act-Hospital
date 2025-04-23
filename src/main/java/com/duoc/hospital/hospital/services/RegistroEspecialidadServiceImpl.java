package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.dtos.RegistroEspecialidadDTO;
import com.duoc.hospital.hospital.dtos.RegistroEspecialidadViewDTO;
import com.duoc.hospital.hospital.exceptions.EspecialidadException;
import com.duoc.hospital.hospital.exceptions.MedicoException;
import com.duoc.hospital.hospital.exceptions.ResgistroEspecialidadException;
import com.duoc.hospital.hospital.models.Especialidad;
import com.duoc.hospital.hospital.models.Medico;
import com.duoc.hospital.hospital.models.RegistroEspecialidad;
import com.duoc.hospital.hospital.repositories.EspecialidadRepository;
import com.duoc.hospital.hospital.repositories.MedicoRepository;
import com.duoc.hospital.hospital.repositories.RegistroEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroEspecialidadServiceImpl implements RegistroEspecialidadService {

    /**
     * Para trabajar con cada una de las entidades se debe linkear cada uno de los repositorios que se trabajara
     */
    @Autowired
    private RegistroEspecialidadRepository registroEspecialidadRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<RegistroEspecialidad> findAll() {
        return registroEspecialidadRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public RegistroEspecialidad findById(Long id) {
        return registroEspecialidadRepository.findById(id).orElseThrow(
                () -> new ResgistroEspecialidadException("Registro con id " + id + " no encontrado")
        );
    }

    @Transactional
    @Override
    public RegistroEspecialidad save(RegistroEspecialidadDTO registroEspecialidad) {
        RegistroEspecialidad registroEspecialidadEntity = new RegistroEspecialidad();

        Especialidad especialidad =  especialidadRepository.findById(
                registroEspecialidad.getEspecialidadId()
        ).orElseThrow(
                () -> new EspecialidadException("La especialidad con id " + registroEspecialidad.getEspecialidadId() +
                        " no existe")
        );

        Medico medico = medicoRepository.findById(
                registroEspecialidad.getMedicoId()
        ).orElseThrow(
                () -> new MedicoException("El medico con id "+ registroEspecialidad.getMedicoId()
                        +" no existe")
        );

        registroEspecialidadEntity.setEspecialidad(especialidad);
        registroEspecialidadEntity.setMedico(medico);
        registroEspecialidadEntity.setFecha(registroEspecialidad.getFecha());
        registroEspecialidadEntity.setUniversidad(registroEspecialidad.getUniversidad());
        return registroEspecialidadRepository.save(registroEspecialidadEntity);

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        registroEspecialidadRepository.deleteById(id);
    }
}
