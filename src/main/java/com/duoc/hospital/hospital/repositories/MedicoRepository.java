package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidadEquals(String especialidad);

    Optional<Medico> findByRun(String run);


}
