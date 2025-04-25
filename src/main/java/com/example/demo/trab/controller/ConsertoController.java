package com.example.demo.trab.controller;

import com.example.demo.trab.model.conserto.*;
import com.example.demo.trab.service.ConsertoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoService consertoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> cadastrar(@RequestBody @Valid DadosCadastroConserto dados,
                                                           UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoConserto consertoDto = consertoService.cadastrar(dados);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(consertoDto.id()).toUri();
        return ResponseEntity.created(uri).body(consertoDto);

    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listarConsertos(Pageable paginacao) {
        Page<Conserto> dadosConserto = consertoService.listarConsertos(paginacao);

        return ResponseEntity.ok(dadosConserto);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosResumoConserto>> resumirConsertos() {
        List<DadosResumoConserto> consertos = consertoService.resumirConsertos();

        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoConserto> listarConsertoPorId(@PathVariable Long id){
        DadosDetalhamentoConserto consertoEscolhido = consertoService.listarConserto(id);

        return ResponseEntity.ok(consertoEscolhido);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> atualizarConserto(@RequestBody @Valid DadosAtualizacaoConserto dados){
        DadosDetalhamentoConserto consertoAtualizado = consertoService.atualizarConserto(dados);

        return ResponseEntity.ok(consertoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> finalizarConserto(@PathVariable Long id){
        consertoService.finalizarConserto(id);
        return ResponseEntity.ok().build();
    }
}