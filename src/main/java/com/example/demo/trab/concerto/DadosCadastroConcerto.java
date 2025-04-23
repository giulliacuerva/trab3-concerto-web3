package com.example.demo.trab.concerto;

import com.example.demo.trab.mecanico.Mecanico;
import com.example.demo.trab.veiculo.Veiculo;

public record DadosCadastroConcerto(String dtEntrada, String dtSaida, Mecanico mecanico, Veiculo veiculo) {
}
