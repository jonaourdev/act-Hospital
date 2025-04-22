package com.duoc.hospital.hospital.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="medicos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Integer medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo run no puede ser vacio")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El fomato del dni debe ser XXXXXXXX-X")
    private String run;

    @Column(name="nombre_completo", nullable = false)
    @NotBlank(message = "El campo nombre completo no puede ser vacio")
    private String nombreCompleto;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false)
    private Boolean jefeTurno;

    @Embedded
    private Audit audit = new Audit();


}
