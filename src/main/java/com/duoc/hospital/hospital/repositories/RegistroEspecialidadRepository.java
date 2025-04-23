package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.RegistroEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEspecialidadRepository extends JpaRepository<RegistroEspecialidad, Long> {
}
