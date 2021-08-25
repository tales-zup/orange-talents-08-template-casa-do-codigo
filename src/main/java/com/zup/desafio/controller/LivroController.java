package com.zup.desafio.controller;

import com.zup.desafio.modelo.Livro;
import com.zup.desafio.repositorio.LivroRepositorio;
import com.zup.desafio.web.LivroListagemResponse;
import com.zup.desafio.web.LivroRequest;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    @Transactional
    public ResponseEntity<List<LivroListagemResponse>> listarLivros() {
        List<Livro> livros = repositorio.findAll();

        List<LivroListagemResponse> responseList = new ArrayList<>();
        for(Livro livro : livros)
            responseList.add(new LivroListagemResponse(livro));

        return ResponseEntity.ok().body(responseList);
    }

}
