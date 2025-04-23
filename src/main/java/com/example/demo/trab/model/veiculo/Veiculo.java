package com.example.demo.trab.model.veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(DadosCadastroVeiculo dados) {
        this.ano = dados.ano();
        this.modelo = dados.modelo();
        this.marca = dados.marca();
    }
}
