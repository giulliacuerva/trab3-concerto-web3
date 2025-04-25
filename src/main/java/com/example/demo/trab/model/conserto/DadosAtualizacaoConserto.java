package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.DadosCadastroMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(@NotNull Long id,
                                       String dtSaida,
                                       DadosCadastroMecanico mecanico) {
}
