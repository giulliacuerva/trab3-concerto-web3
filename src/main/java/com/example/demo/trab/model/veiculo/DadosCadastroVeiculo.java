package com.example.demo.trab.model.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVeiculo(@NotBlank String  marca,
                                   @NotBlank String modelo,
                                   @NotBlank @Pattern(regexp = "^\\d{4}$") String ano,
                                    String cor) {
    public DadosCadastroVeiculo (Veiculo veiculo){
        this(veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor());
    }
}
