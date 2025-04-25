package com.example.demo.trab.model.conserto;

import jakarta.validation.constraints.NotNull;

public record DadosResumoConserto (@NotNull Long id,
                                   String dtInicio,
                                   String dtsaida,
                                   String nome,
                                   String marca,
                                   String modelo){
    public DadosResumoConserto (Conserto conserto){
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
