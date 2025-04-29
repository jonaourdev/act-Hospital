package com.duoc.hospital.hospital.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class AtencionViewPacienteDTO {

    private LocalDateTime horaAtencion;
    private Integer costo;
    private String comentario;
    private String runMedico;
    private String nombreMedico;


}
