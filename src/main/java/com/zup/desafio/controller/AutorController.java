package com.zup.desafio.controller;

import com.zup.desafio.modelo.Autor;
import com.zup.desafio.repositorio.AutorRepositorio;
import com.zup.desafio.web.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepositorio repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorRequest request) {

        Autor autor = new Autor(request.getNome(), request.getEmail(), request.getDescricao());
        repositorio.save(autor);

        return ResponseEntity.ok("Autor cadastrado com sucesso!");
    }

}
