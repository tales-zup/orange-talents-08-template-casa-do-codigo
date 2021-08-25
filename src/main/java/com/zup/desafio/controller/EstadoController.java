package com.zup.desafio.controller;

import com.zup.desafio.handler.BadRequestException;
import com.zup.desafio.modelo.Estado;
import com.zup.desafio.modelo.Pais;
import com.zup.desafio.repositorio.EstadoRepositorio;
import com.zup.desafio.repositorio.PaisRepositorio;
import com.zup.desafio.web.EstadoRequest;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepositorio estadoRepositorio;

    @Autowired
    private PaisRepositorio paisRepositorio;

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoRequest request) throws BadRequestException {
        Pais pais = paisRepositorio.findById(request.getIdPais()).orElseThrow(
                () -> new EntityNotFoundException("Esse país não existe."));

        Estado estado = estadoRepositorio.findByPais_NomeAndNome(pais.getNome(), request.getNome());
        if(estado != null)
            throw new BadRequestException("Já existe um estado com esse nome nesse mesmo país.");

        estado = new Estado(request.getNome(), pais);
        estadoRepositorio.save(estado);
        return ResponseEntity.ok("Estado cadastrado com sucesso!");
    }

}
