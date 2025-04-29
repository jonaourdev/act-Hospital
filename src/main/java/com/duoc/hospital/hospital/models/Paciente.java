package com.duoc.hospital.hospital.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Entity -> Nos permite definir que esta tabla estará almacenada en la BD que se declara en el properties
 * @Table -> Nos permite setear el nombre de la tabla con la que trabajaremos.
 * @Getter -> Se generan todos getters de la clase automáticamente
 * @Setter -> Se generan todos los seter de la clase automáticamente
 */
@Entity
@Table(name = "pacientes")
@Getter @Setter @NoArgsConstructor @ToString
public class Paciente {

    /**
     * @Id -> Se define como la llave primaria del elemento
     * @GeneratedValue -> Nos permite generar el valor de id de forma automatica
     * @Column -> Nos permite generar las propiedades de un campo  que no sea nulo, que sea unico, como se llamara el
     * campo en la base de datos entre otros.
     *
     * --------------------------- Propiedades de la dependencia Validation --------------------------------------------
     *
     * @NotBlank -> Nos permite definir que cuando se envia un body desde postman o desde una pagina web que el campo
     * que seteo esta anotación no pueda venir en blanco. Esto sirve solo para campos del tipo String
     * @NotNull -> En caso que el campo no sea un String podemos setear el campo como Not Null para definir que no sea
     * nulo este campo.
     *
     * Cabe destacar que estas dos anotaciones tienen como parámetro 'message' donde este define el mensaje de error en
     * caso que el JSON del body venga sin este campo.
     *
     * @Pattern -> Me permite definir patrones de entrada a través de una anotación regex, en caso de no entender como
     * puede ser utilizado el campo regex pueden visitar esta pagina:
     * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
     *
     * @Email -> Esta anotacion nos permite validar que el campo que estamos ingresando sea realmente un campo del tipo
     * correo en caso que no sea este valor se genera una excepcion con un mensaje tipo.
     *
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;


    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo rut no puede ser vacio")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El fomato del dni debe ser XXXXXXXX-X")
    private String run;

    @Column(nullable = false)
    @NotBlank(message = "El campo nombres no puede ser vacio")
    private String nombres;

    @Column(nullable = false)
    @NotBlank(message = "El campo apellidos no puede ser vacio")
    private String apellidos;

    @Column(name ="fecha_nacimiento")
    @NotNull(message = "El campo fecha de nacimiento no puede ser vacio")
    private Date fechaNacimiento;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El campo correo no puede ser vacio")
    @Email(message = "El correo debe tener un formato de correo")
    private String correo;

    // Con este codigo podemos decir que se agregen los campos a la tabla de createdAt y updatedAt
    // Si bien en postmant no aparecerá como si fuera una estructura anidada estos pertenecran a la misma tabla
    @Embedded
    private Audit audit = new Audit();

    @JsonManagedReference("paciente-medico")
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Atencion> atenciones = new ArrayList<>();

    @ManyToOne    //???????
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    @JsonBackReference("tipo")
    private TipoUsuario tipoUsuario;
}
