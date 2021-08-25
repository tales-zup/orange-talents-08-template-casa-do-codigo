package com.zup.desafio.web;

import javax.validation.constraints.NotEmpty;

public class EnderecoRequest {

    @NotEmpty
    private String logradouro;

    @NotEmpty
    private String complemento;

    @NotEmpty
    private String cep;

}
