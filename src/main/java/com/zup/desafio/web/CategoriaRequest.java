package com.zup.desafio.web;

import com.zup.desafio.validation.NotNomeDuplicado;

import javax.validation.constraints.NotEmpty;

public class CategoriaRequest {

    @NotEmpty
    @NotNomeDuplicado
    private String nome;

    public String getNome() {
        return nome;
    }
}
