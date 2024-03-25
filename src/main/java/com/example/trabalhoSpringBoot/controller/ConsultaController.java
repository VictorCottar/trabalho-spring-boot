package com.example.trabalhoSpringBoot.controller;


import com.example.trabalhoSpringBoot.model.Consulta;
import com.example.trabalhoSpringBoot.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @GetMapping
    public List<Consulta> listarConsultas() {
        return consultaService.listar();
    }

    @PostMapping
    public Consulta criarConsulta(@RequestBody Consulta consulta) {
        return consultaService.criar(consulta);
    }

    @PutMapping("/atualizar-consulta/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Long id) {
        if (consultaService.atualizar(consulta, id) == null) {
            return (ResponseEntity<Consulta>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(consulta);
        }
    }

    @DeleteMapping("/deletar-consulta/{id}")
    public ResponseEntity<?> deletarConsulta(@PathVariable Long id) {
        String nomeConsulta = consultaService.deletar(id);
        if (nomeConsulta != null) {
            String msg = "A CONSULTA DO PACIENTE " + nomeConsulta + ", FOI DELETADA COM SUCESSO. ID DELETADO: " + id;
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        return null;
    }

    @GetMapping("/quantidade-consulta")
    public int quantidadeDeConsulta(){
        return consultaService.quantidadeDeConsultas();
    }

    @GetMapping("/busca-por-id/{id}")
    public Optional<Consulta> buscaPorId(@PathVariable Long id) {
        return consultaService.buscaPorId(id);
    }

    @GetMapping("/horario-consulta/{id}")
    public ResponseEntity<?> horarioConsulta(@PathVariable Long id) {
        String horarioConsulta = consultaService.horarioConsulta(id);
        if (horarioConsulta != null) {
            String msg = "O HORÁRIO DA CONSULTA COM O ID " + id + " É: " + horarioConsulta;
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        return null;
    }
}
