package com.zup.desafio.controller;

import com.zup.desafio.modelo.Estado;
import com.zup.desafio.repositorio.EstadoRepositorio;
import com.zup.desafio.web.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepositorio repositorio;

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoRequest request) {
        Estado estado = new Estado(request.getNome());
        repositorio.save(estado);
        return ResponseEntity.ok("Estado cadastrado com sucesso!");
    }

}
