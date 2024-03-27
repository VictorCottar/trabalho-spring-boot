package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService <T extends Pessoa> {

    List<T> listar();
    T criar(T t);
    T atualizar(T t, Long id);
    String deletar(Long id);
    Optional<T> buscaPorId(Long id);

}