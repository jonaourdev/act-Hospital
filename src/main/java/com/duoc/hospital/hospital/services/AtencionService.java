package com.duoc.hospital.hospital.services;

import com.duoc.hospital.hospital.dtos.AtencionCreacionDTO;
import com.duoc.hospital.hospital.dtos.AtencionViewDTO;
import com.duoc.hospital.hospital.models.Atencion;

import java.util.List;

public interface AtencionService {

    List<AtencionViewDTO> findAll();
    Atencion save(AtencionCreacionDTO atencion);
}
