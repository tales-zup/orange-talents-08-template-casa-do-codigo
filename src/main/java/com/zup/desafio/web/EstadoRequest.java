package com.zup.desafio.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
