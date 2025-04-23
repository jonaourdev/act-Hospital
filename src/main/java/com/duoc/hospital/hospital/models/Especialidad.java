package com.duoc.hospital.hospital.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "especialidades")
@Getter @Setter @ToString @NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialidad_id")
    private Long especialidadId;

    @Column(unique = true, nullable = false, name = "tipo_especialidad")
    private String tipoEspecialidad;

}
