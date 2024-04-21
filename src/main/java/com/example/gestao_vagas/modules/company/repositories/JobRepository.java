package com.example.gestao_vagas.modules.company.repositories;

import com.example.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    // "contains" - LIKE
    // SELECT * FROM JOB WHERE description LIKE %filter%
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
