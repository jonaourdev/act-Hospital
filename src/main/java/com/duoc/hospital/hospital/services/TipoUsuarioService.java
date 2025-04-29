package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.models.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {

    List<TipoUsuario> findAll();
    TipoUsuario save(TipoUsuario tipo);

}
