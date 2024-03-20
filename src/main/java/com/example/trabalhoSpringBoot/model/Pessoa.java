package com.example.trabalhoSpringBoot.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    private String genero;
    @NotNull
    @Column(nullable = false)
    @Size(min = 11, max = 11)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String genero, String cpf) {
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
