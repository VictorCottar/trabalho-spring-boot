package com.example.trabalhoSpringBoot.service;

import com.example.trabalhoSpringBoot.model.Consulta;
import com.example.trabalhoSpringBoot.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }




}
