package com.duoc.hospital.hospital.dtos;

import com.duoc.hospital.hospital.models.Medico;
import com.duoc.hospital.hospital.models.Paciente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter @Setter @NoArgsConstructor @ToString
public class AtencionViewDTO {
    private Long atencionId;
    private LocalDateTime horaAtencion;
    private Integer costo;
    private String comentario;
    private String runMedico;
    private String nombreMedico;
    private String runPaciente;
    private String nombrePaciente;

    public AtencionViewDTO(
            Long atencionId,
            LocalDateTime horaAtencion,
            String comentario,
            Integer costo,
            Medico medico,
            Paciente paciente
    ){
        this.atencionId = atencionId;
        this.horaAtencion = horaAtencion;
        this.comentario = comentario;
        this.costo = costo;
        this.runMedico = medico.getRun();
        this.nombreMedico = medico.getNombreCompleto();
        this.nombrePaciente = paciente.getNombres() + paciente.getApellidos();
        this.runPaciente = paciente.getRun();
    }

}
