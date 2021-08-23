package com.zup.desafio.controller;

import com.zup.desafio.modelo.Autor;
import com.zup.desafio.repositorio.AutorRepositorio;
import com.zup.desafio.web.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepositorio repositorio;

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AlunoRequest request) {

        Autor autor = new Autor(request);
        autor.setarDataCadastro();
        repositorio.save(autor);

        return ResponseEntity.ok("Aluno cadastrado com sucesso!");
    }

}
