package com.duoc.hospital.hospital.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Entity -> Nos permite definir que esta tabla estara almacenada en la BD que se declara en el properties
 * @Table -> Nos permite setear el nombre de la tabla con la que trabajaremos.
 * @Getter -> Se generan todos getters de la clase automaticamente
 * @Setter -> Se generan todos los seter de la clase automaticamente
 */
@Entity
@Table(name = "patients")
@Getter @Setter @NoArgsConstructor @ToString
public class Paciente {

    /**
     * @Id -> Se define como la llave primaria del elemento
     * @GeneratedValue -> Nos permite generar el valor de id de forma automatica
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;


    @Column(unique = true, nullable = false)
    private String run;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(name ="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(nullable = false, unique = true)
    private String correo;

    // Con este codigo podemos decir que se agregen los campos a la tabla de createdAt y updatedAt
    // Si bien en postmant no aparecerá como si fuera una estructura anidada estos pertenecran a la misma tabla
    @Embedded
    private Audit audit = new Audit();

}
