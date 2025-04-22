package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Repository -> Nos permite definir este elemento del tipo repository
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Metodo que me permite realizar la busqueda de un paciente mediante el rut
    Optional<Paciente> findByRun(String run);

    // Metodo que me permite realizar la busqueda de un paciente mediante el correo
    Optional<Paciente> findByCorreo(String correo);
}
