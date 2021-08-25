package com.zup.desafio.controller;

import com.zup.desafio.modelo.Pais;
import com.zup.desafio.repositorio.PaisRepository;
import com.zup.desafio.web.PaisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisRequest request) {
        Pais pais = new Pais(request.getNome());
        repository.save(pais);
        return ResponseEntity.ok("País cadastrado com sucesso.");
    }

}
