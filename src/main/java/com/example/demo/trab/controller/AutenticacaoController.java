package com.example.demo.trab.controller;

import com.example.demo.trab.model.usuario.Usuario;
import com.example.demo.trab.model.usuario.dadosAutenticacao;
import com.example.demo.trab.service.JWTService;
import com.example.demo.trab.util.security.DadosJWT;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager manager;
    private JWTService jwtService;

    public AutenticacaoController(AuthenticationManager manager, JWTService jwtService) {
        this.manager = manager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid dadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken( dados.login(), dados.senha() );
        var authentication = manager.authenticate(token);

        var JWT = jwtService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJWT(JWT));
    }
}