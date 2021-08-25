package com.zup.desafio.web;

import com.zup.desafio.modelo.Pais;
import com.zup.desafio.validation.UniqueValue;

public class PaisRequest {

    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Já existe um País com esse nome.")
    private String nome;

    public PaisRequest(Pais pais) {
        this.nome = pais.getNome();
    }

}
