package com.duoc.hospital.hospital.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @ToString
public class AtencionCreacionDTO {
    @NotNull(message = "El campo hora de atencion no puede ser vacio")
    private LocalDateTime horaAtencion;

    @NotNull(message = "El campo costo no puede ser vacio")
    private Integer costo;

    private String comentario;

    @NotNull(message = "El campo medico ID no puede ser nulo")
    private Long medicoId;

    @NotNull(message = "El campo Paciente ID no puede ser nulo")
    private Long pacienteId;
}
