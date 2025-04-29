package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.dtos.AtencionViewDTO;
import com.duoc.hospital.hospital.dtos.AtencionViewPacienteDTO;
import com.duoc.hospital.hospital.exceptions.PacienteException;
import com.duoc.hospital.hospital.models.Atencion;
import com.duoc.hospital.hospital.models.Paciente;
import com.duoc.hospital.hospital.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findById(Long id) {
        // Se genera metodo que permite realizar la busqueda de un usuario con el id, en caso de no encontrar un resul
        // Se lanza una excepcion que tiene que ver con paciente.
        return pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente con id " + id + " no encontrado")
        );
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
        // Se realiza la validacion que el usuario con el RUT enviado no exista previamente en nuestra base de datos
        if (pacienteRepository.findByRun(paciente.getRun()).isPresent()) {
            throw new PacienteException("Paciente con Run "+paciente.getRun()+" ya existente");
        }
        // Se realiza la validacion que el usuario con el Correo enviado no exista previamente en nuestra base de datos
        if (pacienteRepository.findByCorreo(paciente.getCorreo()).isPresent()) {
            throw new PacienteException("Paciente con Correo "+paciente.getCorreo()+" ya existente");
        }
        return pacienteRepository.save(paciente);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        // Metosdo lamda que nos permite generar la actualizacion de un elemento a traves del metodo MAP en caso de
        // que se encuentre un valor, en caso contrario se genera la excpecion del caso
        return pacienteRepository.findById(id).map(p->{
            p.setNombres(paciente.getNombres());
            p.setApellidos(paciente.getApellidos());
            p.setCorreo(paciente.getCorreo());
            p.setFechaNacimiento(paciente.getFechaNacimiento());
            p.setRun(paciente.getRun());
            return pacienteRepository.save(p);
        }).orElseThrow(
                () -> new PacienteException("Paciente con id " + id + " no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByCorreo(String correo) {
        return pacienteRepository.findByCorreo(correo).orElseThrow(
                () -> new PacienteException("Paciente con Correo "+correo+" no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByRun(String run) {
        return pacienteRepository.findByRun(run).orElseThrow(
                () -> new PacienteException("Paciente con Run "+run+" no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public List<AtencionViewPacienteDTO> findAtencionesById(Long id) {
        Paciente paciente = this.findById(id);
        List<Atencion> atenciones = paciente.getAtenciones();
        return atenciones.stream().map(atencion -> {
            return new AtencionViewPacienteDTO(
                    atencion.getHoraAtencion(),
                    atencion.getCosto(),
                    atencion.getComentario(),
                    atencion.getMedico().getRun(),
                    atencion.getMedico().getNombreCompleto()
            );
        }).collect(Collectors.toList());
    }
}
