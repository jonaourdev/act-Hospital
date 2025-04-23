package com.duoc.hospital.hospital.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="medico_especialidad")
@Getter @Setter @NoArgsConstructor @ToString
public class RegistroEspecialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Long registroId;

    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false)
    @NotNull(message = "El campo de medico no puede ser vacio")
    @JsonBackReference("medico-especialidad")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    @NotNull(message = "El campo de especialidad no puede ser vacio")
    @JsonBackReference("especialidad-medico")
    private Especialidad especialidad;

    @NotNull(message = "El campo de fecha de obtención de especialidad no puede ser vacio")
    private LocalDate fecha;

    @NotBlank(message = "El campo universidad no puede ser vacio")
    private String universidad;

}
