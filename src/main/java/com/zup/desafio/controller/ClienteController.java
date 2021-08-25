package com.zup.desafio.controller;

import com.zup.desafio.handler.BadRequestException;
import com.zup.desafio.modelo.Cliente;
import com.zup.desafio.modelo.Endereco;
import com.zup.desafio.modelo.Estado;
import com.zup.desafio.modelo.Pais;
import com.zup.desafio.repositorio.ClienteRepositorio;
import com.zup.desafio.repositorio.EnderecoRepositorio;
import com.zup.desafio.web.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteRequest request) throws BadRequestException {
        Pais pais = em.find(Pais.class, request.getIdPais());
        List<Estado> estados = pais.getEstados();
        if(!estados.isEmpty() && request.getIdEstado() == null)
            throw new BadRequestException("É obrigatório escolher um estado se o país tiver estados vinculados.");

        Endereco endereco = request.getEndereco().toModel();
        endereco = enderecoRepositorio.save(endereco);
        Cliente cliente = request.toModel(em);
        cliente.setEndereco(endereco);
        clienteRepositorio.save(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }

}
