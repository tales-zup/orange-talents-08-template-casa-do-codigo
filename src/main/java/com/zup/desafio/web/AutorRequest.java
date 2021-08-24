package com.zup.desafio.web;

import com.zup.desafio.validation.NotEmailDuplicado;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AutorRequest {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    @NotEmailDuplicado
    private String email;

    @NotEmpty
    @Length(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
