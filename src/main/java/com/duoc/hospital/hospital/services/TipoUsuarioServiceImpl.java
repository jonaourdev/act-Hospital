package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.exceptions.TipoUsuarioException;
import com.duoc.hospital.hospital.models.Atencion;
import com.duoc.hospital.hospital.models.Paciente;
import com.duoc.hospital.hospital.models.TipoUsuario;
import com.duoc.hospital.hospital.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario save(TipoUsuario tipo) {
        if (tipoUsuarioRepository.findByNombre(tipo.getNombre()).isPresent()){
            throw new TipoUsuarioException("El nombre "+tipo.getNombre()+" ya existe.");
        }

        return tipoUsuarioRepository.save(tipo);
    }

    @Override
    public Integer costoTotalAtenciones(Long id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id).orElseThrow(
                ()-> new TipoUsuarioException("El tipo de usuario con id "+id+" no existe.")
        );
        Integer total=0;
        for(Paciente paciente: tipoUsuario.getPacientes()){
            for (Atencion atencion: paciente.getAtenciones()){
                total+=atencion.getCosto();
            }

        }
        return total;
    }

}
