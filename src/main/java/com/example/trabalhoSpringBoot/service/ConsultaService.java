package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Consulta;
import com.example.trabalhoSpringBoot.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService  implements PessoaService<Consulta>{

    @Autowired
    ConsultaRepository consultaRepository;


    @Override
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta criar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta atualizar(Consulta consulta, Long id) {
        if (consultaRepository.existsById(id)) {
            consulta.setId(id);
            return consultaRepository.save(consulta);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int quantidadeDeConsultas() {
        return consultaRepository.findAll().size();
    }

    public Optional<Consulta> buscaPorId(Long id) {
        return consultaRepository.findById(id);
    }

}