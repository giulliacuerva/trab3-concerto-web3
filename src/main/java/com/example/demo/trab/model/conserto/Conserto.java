package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.DadosCadastroMecanico;
import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.DadosCadastroVeiculo;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.persistence.Embedded;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dtEntrada;
    private String dtSaida;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nome", column = @Column(name = "mecanico_nome")),
            @AttributeOverride(name = "anosExperiencia", column = @Column(name = "mecanico_anos_experiencia"))
    })
    private Mecanico mecanico;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "marca", column = @Column(name = "veiculo_marca")),
            @AttributeOverride(name = "modelo", column = @Column(name = "veiculo_modelo")),
            @AttributeOverride(name = "ano", column = @Column(name = "veiculo_ano")),
            @AttributeOverride(name = "cor", column = @Column(name = "veiculo_cor"))
    })
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.dtEntrada = dados.dtEntrada();
        this.dtSaida = dados.dtSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizar(DadosAtualizacaoConserto dados) {
        Optional.ofNullable(dados.dtSaida()).ifPresent(dtSaida -> this.dtSaida = dtSaida);
        Optional.ofNullable(dados.mecanico()).ifPresent(nome -> this.mecanico.atualizarDados(dados.mecanico()));
    }

    public void finalizar() {
        this.ativo = false;
    }
}
