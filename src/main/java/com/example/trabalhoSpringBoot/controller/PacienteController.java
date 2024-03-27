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
        return pacienteService.listar();
    }

    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.criar(paciente);
    }

    @PutMapping("/atualizar-paciente/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente, @PathVariable Long id) {
        if (pacienteService.atualizar(paciente, id) == null) {
            return (ResponseEntity<Paciente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(paciente);
        }
    }

    @DeleteMapping("/deletar-paciente/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable Long id) {
        String nomePaciente = pacienteService.deletar(id);
        if (nomePaciente != null) {
            String msg = "O PACIENTE " + nomePaciente + " DO ID " + id + " FOI DELETADO COM SUCESSO.";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        return null;
    }

    @GetMapping("/quantidade-paciente")
    public int quantidadeDePaciente(){
        return pacienteService.quantidadeDePacientes();
    }

    @GetMapping("/busca-por-id/{id}")
    public Optional<Paciente> buscaPorId(@PathVariable Long id) {
        return pacienteService.buscaPorId(id);
    }

    @GetMapping("/maior-idade/{x}")
    public List<Paciente> maiorIdade(@PathVariable double x) {
        return pacienteService.maiorIdade(x);
    }

    @GetMapping("/busca-por-nome/{nome}")
    public List<Paciente> buscaPorNome(@PathVariable String nome) {
        return pacienteService.buscaPorNome(nome);
    }
}