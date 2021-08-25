package com.zup.desafio.web;

import com.zup.desafio.modelo.Cliente;
import com.zup.desafio.modelo.Endereco;
import com.zup.desafio.modelo.Estado;
import com.zup.desafio.modelo.Pais;
import com.zup.desafio.validation.ExistsId;
import com.zup.desafio.validation.UniqueValue;

import javax.persistence.EntityManager;
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
    private EnderecoRequest endereco;

    private Long idEstado;

    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Esse país não existe.")
    private Long idPais;

    public Cliente toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, idPais);
        Estado estado = null;
        if(idEstado != null)
            estado = em.find(Estado.class, idEstado);
        return new Cliente(email, nome, sobrenome, documento, telefone, endereco.toModel(), estado, pais);
    }

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

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }
}
