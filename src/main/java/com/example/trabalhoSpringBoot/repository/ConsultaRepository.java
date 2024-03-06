package com.example.trabalhoSpringBoot.repository;

import com.example.trabalhoSpringBoot.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
