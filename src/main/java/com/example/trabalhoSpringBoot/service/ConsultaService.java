package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Consulta;
import com.example.trabalhoSpringBoot.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    private boolean verificaId(Long id) {
        if (consultaRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta atualizarConsulta(Consulta consulta, Long id) {
        if (verificaId(id)) {
            consulta.setId(id);
            return consultaRepository.save(consulta);
        }
        return null;
    }

    public boolean deletarConsulta(Long id) {
        if (verificaId(id)) {
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