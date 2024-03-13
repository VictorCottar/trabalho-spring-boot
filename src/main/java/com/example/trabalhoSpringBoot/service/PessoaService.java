package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Pessoa;

import java.util.List;

public interface PessoaService <T extends Pessoa>{

    List<T> listar();
    T criar(T t);
    T atualizar(T t, Long id);
    boolean deletar(Long id);

    //implementar os metodos abstratos nas services
}
