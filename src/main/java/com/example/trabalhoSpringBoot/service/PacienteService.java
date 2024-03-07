package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Paciente;
import com.example.trabalhoSpringBoot.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Paciente paciente, Long id) {
        if (verificaId(id)) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    private boolean verificaId(Long id) {
        if (pacienteRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletarPaciente(Long id) {
        if (verificaId(id)) {
            pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public String getNomePaciente() {
         return  pacienteRepository.getClass().getName();
    }

    public int quantidadeDePacientes() {
        return pacienteRepository.findAll().size();
    }

    public Optional<Paciente> buscaPorId(Long id) {
        return pacienteRepository.findById(id);
    }

}