package com.zup.desafio.web;

import com.zup.desafio.modelo.Autor;
import com.zup.desafio.validation.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AutorRequest {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Já existe um Autor com esse nome.")
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
