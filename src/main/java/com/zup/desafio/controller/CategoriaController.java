package com.zup.desafio.controller;

import com.zup.desafio.modelo.Categoria;
import com.zup.desafio.repositorio.CategoriaRepositorio;
import com.zup.desafio.web.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepositorio repositorio;

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaRequest request) {
        Categoria categoria = new Categoria(request);
        repositorio.save(categoria);

        return ResponseEntity.ok("Categoria cadastrada com sucesso!");
    }

}
