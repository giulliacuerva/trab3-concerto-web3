package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoConserto(Long id,
                                        @NotBlank String dtEntrada,
                                        @NotBlank String dtSaida,
                                        @NotNull @Valid Mecanico mecanico,
                                        @NotNull @Valid Veiculo veiculo) {
    public DadosDetalhamentoConserto (Conserto conserto){
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}
