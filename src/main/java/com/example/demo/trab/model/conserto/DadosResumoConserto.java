package com.example.demo.trab.model.conserto;

public record DadosResumoConserto (String dtInicio,
                                  String dtsaida,
                                  String nome,
                                  String marca,
                                  String modelo){
    public DadosResumoConserto (Conserto conserto){
        this(conserto.getDtEntrada(), conserto.getDtSaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
