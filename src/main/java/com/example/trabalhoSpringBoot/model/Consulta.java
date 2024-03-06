package com.example.trabalhoSpringBoot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Consulta extends Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer horaDaConsulta;

    private String consulta;

    public Consulta(String nome, String cpf, Long id, Integer horaDaConsulta, String consulta) {
        super(nome, cpf);
        this.id = id;
        this.horaDaConsulta = horaDaConsulta;
        this.consulta = consulta;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHoraDaConsulta() {
        return horaDaConsulta;
    }

    public void setHoraDaConsulta(Integer horaDaConsulta) {
        this.horaDaConsulta = horaDaConsulta;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

}