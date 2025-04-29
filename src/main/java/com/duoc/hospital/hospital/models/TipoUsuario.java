package com.duoc.hospital.hospital.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_usuarios")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_usuario_id")
    private Long tipoUsuarioId;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String nombre;


    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> pacientes = new ArrayList<>();

}

