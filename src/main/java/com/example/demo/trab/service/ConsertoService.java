package com.example.demo.trab.service;

import com.example.demo.trab.model.conserto.Conserto;
import com.example.demo.trab.model.conserto.ConsertoRepository;
import com.example.demo.trab.model.conserto.DadosCadastroConserto;
import com.example.demo.trab.model.conserto.DadosDetalhamentoConserto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsertoService {

    @Autowired
    private ConsertoRepository repository;

    public DadosDetalhamentoConserto cadastrar(DadosCadastroConserto dadosConserto){
        Conserto conserto = new Conserto(dadosConserto);
        repository.save(conserto);

        return new DadosDetalhamentoConserto(conserto);
    }

}
