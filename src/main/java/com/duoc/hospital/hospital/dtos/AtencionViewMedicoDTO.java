package com.duoc.hospital.hospital.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class AtencionViewMedicoDTO {

    private LocalDateTime horaAtencion;
    private Integer costo;
    private String comentario;
    private String runPaciente;
    private String nombrePaciente;

}
