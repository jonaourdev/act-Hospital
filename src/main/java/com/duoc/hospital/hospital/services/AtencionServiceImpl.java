package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.dtos.AtencionCreacionDTO;
import com.duoc.hospital.hospital.dtos.AtencionViewDTO;
import com.duoc.hospital.hospital.exceptions.MedicoException;
import com.duoc.hospital.hospital.exceptions.PacienteException;
import com.duoc.hospital.hospital.models.Atencion;
import com.duoc.hospital.hospital.models.Medico;
import com.duoc.hospital.hospital.models.Paciente;
import com.duoc.hospital.hospital.repositories.AtencionRepository;
import com.duoc.hospital.hospital.repositories.MedicoRepository;
import com.duoc.hospital.hospital.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtencionServiceImpl implements AtencionService{
    @Autowired
    private AtencionRepository atencionRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<AtencionViewDTO> findAll() {
        return atencionRepository.findAll().stream().map(atencion -> {
            return new AtencionViewDTO(
                    atencion.getAtencionId(),
                    atencion.getHoraAtencion(),
                    atencion.getComentario(),
                    atencion.getCosto(),
                    atencion.getMedico(),
                    atencion.getPaciente()
            );
        }).collect(Collectors.toList());
    }

    @Override
    public Atencion save(AtencionCreacionDTO atencion) {
        Medico medico = medicoRepository.findById(
                atencion.getMedicoId()
        ).orElseThrow(
                () -> new MedicoException("El medico con id "+atencion.getMedicoId()+" no encontrado")
        );

        Paciente paciente = pacienteRepository.findById(
                atencion.getPacienteId()
        ).orElseThrow(
                () -> new PacienteException("El paciente con id "+atencion.getPacienteId()
                        +" no encontrado")
        );

        Atencion atencionNew = new Atencion();
        atencionNew.setMedico(medico);
        atencionNew.setPaciente(paciente);
        atencionNew.setCosto(atencion.getCosto());
        atencionNew.setHoraAtencion(atencion.getHoraAtencion());
        atencionNew.setComentario(atencion.getComentario());

        return atencionRepository.save(atencionNew);
    }
}
