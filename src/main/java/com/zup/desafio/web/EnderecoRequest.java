package com.zup.desafio.web;

import com.zup.desafio.modelo.Endereco;

import javax.validation.constraints.NotEmpty;

public class EnderecoRequest {

    @NotEmpty
    private String logradouro;

    @NotEmpty
    private String complemento;

    @NotEmpty
    private String cep;

    public Endereco toModel() {
        return new Endereco(logradouro, complemento, cep);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }
}
