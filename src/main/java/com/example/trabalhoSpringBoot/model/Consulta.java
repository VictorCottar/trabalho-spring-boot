package com.example.trabalhoSpringBoot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Consulta extends Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 5)
    private String horaDaConsulta;

    @NotNull
    private String consulta;

    public Consulta(){

    }

    public Consulta(String nome, String cpf, Long id, String horaDaConsulta, Integer idade, String consulta) {
        super(nome, cpf, idade);
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

    public String getHoraDaConsulta() {
        return horaDaConsulta;
    }

    public void setHoraDaConsulta(String horaDaConsulta) {
        this.horaDaConsulta = horaDaConsulta;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

}