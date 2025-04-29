package com.duoc.hospital.hospital.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class PacienteCreacionDTO {

    @NotBlank(message = "El campo rut no puede ser vacio")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El fomato del dni debe ser XXXXXXXX-X")
    private String run;

    @NotBlank(message = "El campo nombres no puede ser vacio")
    private String nombres;

    @NotBlank(message = "El campo apellidos no puede ser vacio")
    private String apellidos;

    @NotNull(message = "El campo fecha de nacimiento no puede ser vacio")
    private Date fechaNacimiento;

    @NotBlank(message = "El campo correo no puede ser vacio")
    @Email(message = "El correo debe tener un formato de correo")
    private String correo;

    @NotNull(message = "El campo tipo de usuario no puede ser vacío")
    private Long tipoUsuarioId;


}
