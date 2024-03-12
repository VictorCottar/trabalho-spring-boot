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
        return consultaService.listarConsultas();
    }

    @PostMapping
    public Consulta criarConsulta(@RequestBody Consulta consulta) {
        return consultaService.criarConsulta(consulta);
    }

    @PutMapping("/atualizar-consulta/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Long id) {
        if (consultaService.atualizarConsulta(consulta, id) == null) {
            return (ResponseEntity<Consulta>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(consulta);
        }
    }

    @DeleteMapping("/deletar-consulta/{id}")
    public ResponseEntity<?> deletarConsulta(@PathVariable Long id) {
        if (consultaService.deletarConsulta(id)) {
            String msg = "A CONSULTA DO ID " + id + " FOI DELETADA COM SUCESSO";
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
}
