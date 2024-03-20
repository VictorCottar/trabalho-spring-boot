package com.example.trabalhoSpringBoot.repository;

import com.example.trabalhoSpringBoot.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


}
