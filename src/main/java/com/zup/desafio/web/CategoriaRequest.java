package com.zup.desafio.web;

import com.zup.desafio.modelo.Categoria;
import com.zup.desafio.validation.UniqueValue;

import javax.validation.constraints.NotEmpty;

public class CategoriaRequest {

    @NotEmpty
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Já existe uma Categoria com esse nome.")
    private String nome;

    public String getNome() {
        return nome;
    }
}
