package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository -> Nos permite definir este elemento del tipo repository
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
