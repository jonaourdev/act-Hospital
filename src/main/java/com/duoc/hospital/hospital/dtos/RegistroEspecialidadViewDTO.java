package com.duoc.hospital.hospital.dtos;

import com.duoc.hospital.hospital.models.Especialidad;
import com.duoc.hospital.hospital.models.Medico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
@ToString
public class RegistroEspecialidadViewDTO {


    private Long registroId;

    private Medico medico;

    private Especialidad especialidad;

    private LocalDate fecha;

    private String universidad;
}
