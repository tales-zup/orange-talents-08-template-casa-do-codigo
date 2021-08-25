package com.zup.desafio.web;

import com.zup.desafio.modelo.Cliente;
import com.zup.desafio.modelo.Endereco;
import com.zup.desafio.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotEmpty
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Já existe um cliente com esse email.")
    private String email;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Já existe um cliente com esse documento.")
    private String documento;

    @NotEmpty
    private String telefone;

    @NotNull
    private Endereco endereco;

    private Long idEstado;

    @NotNull
    private Long idPais;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }
}
