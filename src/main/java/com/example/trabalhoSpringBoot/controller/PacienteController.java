package com.example.trabalhoSpringBoot.controller;

import com.example.trabalhoSpringBoot.model.Paciente;
import com.example.trabalhoSpringBoot.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.criarPaciente(paciente);
    }

    @PostMapping("/atualizar-paciente/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente, @PathVariable Long id) {
        if (pacienteService.atualizarPaciente(paciente, id) == null) {
            return (ResponseEntity<Paciente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(paciente);
        }
    }

    @DeleteMapping("/deletar-paciente/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable Long id) {
        if (pacienteService.deletarPaciente(id)) {
            String msg = "O PACIENTE " + pacienteService.getNomePaciente() + "DO ID " + id + " FOI DELETADO COM SUCESSO.";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        return null;
    }

    @GetMapping("/quantidade-paciente")
    public int quantidadeDePaciente(){
        return pacienteService.quantidadeDePacientes();
    }

    //corrigir esta função.
    @GetMapping("/busca-por-id/{id}")
    public Optional<Paciente> buscaPorId(Long id) {
        return pacienteService.buscaPorId(id);
    }
}