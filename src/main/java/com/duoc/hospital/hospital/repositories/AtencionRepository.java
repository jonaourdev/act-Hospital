package com.duoc.hospital.hospital.repositories;

import com.duoc.hospital.hospital.models.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion,Long> {
}
