package com.zup.desafio.controller;

import com.zup.desafio.modelo.Livro;
import com.zup.desafio.repositorio.LivroRepositorio;
import com.zup.desafio.web.LivroRequest;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LivroRepositorio repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroRequest request) {

        Livro livro = request.converter(em);
        repositorio.save(livro);
        return ResponseEntity.ok("Livro cadastrado com sucesso!");

    }

}
