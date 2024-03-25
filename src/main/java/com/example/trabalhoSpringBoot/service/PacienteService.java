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
    public String deletar(Long id) {
        if (pacienteRepository.existsById(id)) {
            Optional<String> nomePacienteOpt = getNomePaciente(id);
            if (nomePacienteOpt.isPresent()) {
                pacienteRepository.deleteById(id);
                return nomePacienteOpt.get();
            }
        } else {
            return null;
        }
        return null;
    }

    public Optional<String> getNomePaciente(Long id) {
        return pacienteRepository.findById(id).map(Paciente::getNome);
    }


    public int quantidadeDePacientes() {
        return pacienteRepository.findAll().size();
    }

    public Optional<Paciente> buscaPorId(Long id) {
        return pacienteRepository.findById(id);
    }
}