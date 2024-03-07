package com.example.trabalhoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @NotNull
    private String cpf;

    private Integer idade;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}