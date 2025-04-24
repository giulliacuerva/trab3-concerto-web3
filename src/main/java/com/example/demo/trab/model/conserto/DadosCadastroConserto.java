package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.DadosCadastroMecanico;
import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.DadosCadastroVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroConserto(@NotBlank @Pattern(regexp = "^([0][1-9]|[12][0-9]|3[01])/([0][1-9]|1[0-2])/\\d{4}$") String dtEntrada,
                                    @NotBlank @Pattern(regexp = "^([0][1-9]|[12][0-9]|3[01])/([0][1-9]|1[0-2])/\\d{4}$") String dtSaida,
                                    @NotNull @Valid DadosCadastroMecanico mecanico,
                                    @NotNull @Valid DadosCadastroVeiculo veiculo) {

}
