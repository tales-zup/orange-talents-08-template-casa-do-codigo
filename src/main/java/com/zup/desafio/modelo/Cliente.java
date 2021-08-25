package com.zup.desafio.modelo;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String telefone;

    @OneToOne
    private Endereco endereco;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Pais pais;

    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String telefone,
                   Endereco endereco, Estado estado, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estado = estado;
        this.pais = pais;
    }
}
