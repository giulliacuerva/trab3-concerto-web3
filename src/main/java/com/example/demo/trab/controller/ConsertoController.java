package com.example.demo.trab.controller;

import com.example.demo.trab.model.conserto.DadosCadastroConserto;
import com.example.demo.trab.model.conserto.DadosDetalhamentoConserto;
import com.example.demo.trab.service.ConsertoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoService consertoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> cadastrar(@RequestBody DadosCadastroConserto dados,
                                                           UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoConserto consertoDto = consertoService.cadastrar(dados);

        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(consertoDto).toUri();
        return ResponseEntity.created(uri).body(consertoDto);

    }
}