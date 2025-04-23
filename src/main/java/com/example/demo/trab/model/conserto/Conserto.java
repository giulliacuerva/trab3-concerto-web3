package com.example.demo.trab.model.conserto;

import com.example.demo.trab.model.mecanico.Mecanico;
import com.example.demo.trab.model.veiculo.Veiculo;
import jakarta.persistence.Embedded;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "concerto")
@Entity(name = "Concerto")
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
            @AttributeOverride(name = "ano", column = @Column(name = "veiculo_ano"))
    })
    private Veiculo veiculo;

    public Conserto(DadosCadastroConserto dados) {
        this.dtEntrada = dados.dtEntrada();
        this.dtSaida = dados.dtSaida();
        this.mecanico = dados.mecanico();
        this.veiculo = dados.veiculo();
    }
}
