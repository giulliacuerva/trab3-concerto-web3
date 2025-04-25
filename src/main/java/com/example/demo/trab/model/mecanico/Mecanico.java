package com.example.demo.trab.model.mecanico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String anosExperiencia;

    public Mecanico(DadosCadastroMecanico dados) {
        this.nome = dados.nome();
        this.anosExperiencia = dados.anosExperiencia();
    }


    public void atualizarDados(DadosCadastroMecanico mecanico) {
        Optional.ofNullable(mecanico.nome()).ifPresent(nome -> this.nome = nome);
        Optional.ofNullable(mecanico.anosExperiencia()).ifPresent(anos -> this.anosExperiencia = anos);
    }
}
