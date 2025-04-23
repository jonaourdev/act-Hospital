package com.duoc.hospital.hospital.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
public class RegistroEspecialidadDTO {

    @NotNull(message = "El campo de medico no puede ser vacio")
    private Long medicoId;

    @NotNull(message = "El campo de especialidad no puede ser vacia")
    private Long especialidadId;

    @NotNull(message = "El campo de fecha de obtención de especialidad no puede ser vacio")
    private LocalDate fecha;

    @NotBlank(message = "El campo universidad no puede ser vacio")
    private String universidad;
}
