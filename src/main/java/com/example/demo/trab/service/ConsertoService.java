package com.example.demo.trab.service;

import com.example.demo.trab.model.conserto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@Service
public class ConsertoService {

    @Autowired
    private ConsertoRepository repository;

    public DadosDetalhamentoConserto cadastrar(DadosCadastroConserto dadosConserto){
        Conserto conserto = new Conserto(dadosConserto);
        repository.save(conserto);

        return new DadosDetalhamentoConserto(conserto);
    }

    public Page<Conserto> listarConsertos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    public List<DadosResumoConserto> resumirConsertos() {
        return repository.findAll().stream().map(DadosResumoConserto::new).toList();
    }
}
