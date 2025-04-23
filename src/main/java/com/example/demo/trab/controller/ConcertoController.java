package com.example.demo.trab.controller;

import com.example.demo.trab.concerto.Concerto;
import com.example.demo.trab.concerto.ConcertoRepository;
import com.example.demo.trab.concerto.DadosCadastroConcerto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("concerto")
public class ConcertoController {

    @Autowired
    private ConcertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConcerto dados) {
        repository.save(new Concerto(dados));
    }
}