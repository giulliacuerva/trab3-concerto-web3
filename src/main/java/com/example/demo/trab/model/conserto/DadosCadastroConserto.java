package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroConserto(@NotBlank String dtEntrada,
                                    @NotBlank String dtSaida,
                                    @NotBlank Mecanico mecanico,
                                    @NotBlank Veiculo veiculo) {

}
