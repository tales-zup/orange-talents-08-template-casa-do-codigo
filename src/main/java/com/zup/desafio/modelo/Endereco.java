package com.zup.desafio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String complemento;
    private String cep;

    public Endereco(){}

    public Endereco(String logradouro, String complemento, String cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
    }
}
