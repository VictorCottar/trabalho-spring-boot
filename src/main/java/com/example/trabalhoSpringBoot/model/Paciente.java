package com.example.trabalhoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 0, message = "A IDADE NÃO PODE SER MENOR QUE 0.")
    @Max(value = 100, message = "A IDADE NÃO PODE SER MAIOR QUE 100.")
    private Integer idade;

    public Paciente() {
    }

    public Paciente(String nome, String genero, String cpf, Long id, Integer idade) {
        super(nome, genero, cpf);
        this.id = id;
        this.idade = idade;
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