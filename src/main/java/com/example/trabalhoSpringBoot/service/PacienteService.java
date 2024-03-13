package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Paciente;
import com.example.trabalhoSpringBoot.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements PessoaService<Paciente> {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente criar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizar(Paciente paciente, Long id) {
        if (pacienteRepository.existsById(id)) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public String getNomePaciente() {
        return pacienteRepository.getClass().getName();
    }

    public int quantidadeDePacientes() {
        return pacienteRepository.findAll().size();
    }

    public Optional<Paciente> buscaPorId(Long id) {
        return pacienteRepository.findById(id);
    }


}