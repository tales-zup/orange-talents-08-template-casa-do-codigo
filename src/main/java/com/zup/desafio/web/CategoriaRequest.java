package com.zup.desafio.web;

import javax.validation.constraints.NotEmpty;

public class CategoriaRequest {

    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }
}
