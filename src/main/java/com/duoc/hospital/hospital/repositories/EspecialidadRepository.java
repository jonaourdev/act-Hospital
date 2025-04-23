package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    Optional<Especialidad> findByTipoEspecialidadEquals(String tipoEspecialidad);
}
