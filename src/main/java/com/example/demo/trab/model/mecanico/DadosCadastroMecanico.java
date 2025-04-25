package com.example.demo.trab.model.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMecanico(@NotBlank String nome,
                                    String anosExperiencia) {
    public DadosCadastroMecanico (Mecanico mecanico){
        this(mecanico.getNome(), mecanico.getAnosExperiencia());
    }
}
