package com.duoc.hospital.hospital.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="atenciones")
@Getter @Setter @NoArgsConstructor @ToString
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="atencion_id")
    private Long atencionId;

    @Column(name = "hora_atencion", nullable = false)
    @NotNull(message = "El campo hora de atencion no puede ser vacio")
    private LocalDateTime horaAtencion;

    @Column(nullable = false)
    @NotNull(message = "El campo costo no puede ser vacio")
    private Integer costo;

    private String comentario;

    @JsonBackReference("medico-paciente")
    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false)
    @NotNull(message = "El campo medico no puede ser vacio")
    private Medico medico;

    @JsonBackReference("paciente-medico")
    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    @NotNull(message = "El campo paciente no puede ser vacio")
    private Paciente paciente;





}
