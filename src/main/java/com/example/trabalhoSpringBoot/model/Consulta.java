package com.example.trabalhoSpringBoot.model;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Consulta extends Paciente {

    @NotNull
    @Size(min = 5, max = 5)
    private String horaDaConsulta;

    @NotNull
    private String consulta;

    public Consulta(){

    }

    public Consulta(String nome, String cpf, String horaDaConsulta, Integer idade, String consulta) {
        super(nome, cpf, idade);
        this.horaDaConsulta = horaDaConsulta;
        this.consulta = consulta;
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