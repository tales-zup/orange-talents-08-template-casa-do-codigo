package com.zup.desafio.controller;

import com.zup.desafio.modelo.Livro;
import com.zup.desafio.repositorio.LivroRepositorio;
import com.zup.desafio.web.LivroDetalheResponse;
import com.zup.desafio.web.LivroListagemResponse;
import com.zup.desafio.web.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

        Livro livro = request.toModel(em);
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

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<LivroDetalheResponse> detalharLivro(@PathVariable("id") Long id) throws EntityNotFoundException {
        Livro livro = repositorio.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Esse livro não existe."));
        LivroDetalheResponse response = new LivroDetalheResponse(livro);
        return ResponseEntity.ok().body(response);
    }

}
