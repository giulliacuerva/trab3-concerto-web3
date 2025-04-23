package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record DadosDetalhamentoConserto(Long id,
                                        String dtEntrada,
                                        String dtSaida,
                                        Mecanico mecanico,
                                        Veiculo veiculo) {
    public DadosDetalhamentoConserto (Conserto conserto){
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}
