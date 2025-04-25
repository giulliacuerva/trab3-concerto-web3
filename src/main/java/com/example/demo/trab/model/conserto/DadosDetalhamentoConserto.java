package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.DadosCadastroMecanico;
import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.DadosCadastroVeiculo;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoConserto(Long id,
                                        @NotBlank String dtEntrada,
                                        @NotBlank String dtSaida,
                                        @NotNull @Valid DadosCadastroMecanico mecanico,
                                        @NotNull @Valid DadosCadastroVeiculo veiculo) {
    public DadosDetalhamentoConserto (Conserto conserto){
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(),
                new DadosCadastroMecanico(conserto.getMecanico()), new DadosCadastroVeiculo(conserto.getVeiculo()));
    }
}
