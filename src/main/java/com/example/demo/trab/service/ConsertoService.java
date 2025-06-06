package com.example.demo.trab.service;

import com.example.demo.trab.model.conserto.*;
import com.example.demo.trab.persistence.ConsertoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ConsertoService {

    private ConsertoRepository repository;

    public ConsertoService(ConsertoRepository repository) {
        this.repository = repository;
    }

    public DadosDetalhamentoConserto cadastrar(DadosCadastroConserto dadosConserto){
        Conserto conserto = new Conserto(dadosConserto);
        repository.save(conserto);

        return new DadosDetalhamentoConserto(conserto);
    }

    public Page<Conserto> listarConsertos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    public List<DadosResumoConserto> resumirConsertos() {
        return repository.findAllByAtivoTrue().stream().map(DadosResumoConserto::new).toList();
    }

    public DadosDetalhamentoConserto listarConserto(Long id) {
        Conserto conserto = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conserto não encontrado."));

        return new DadosDetalhamentoConserto(conserto);
    }

    public DadosDetalhamentoConserto atualizarConserto(DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.findById(dados.id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conserto não encontrado."));

        conserto.atualizar(dados);
        return new DadosDetalhamentoConserto(conserto);

    }

    public void finalizarConserto(Long id) {
        Conserto conserto = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conserto não encontrado."));

        conserto.finalizar();
    }
}
