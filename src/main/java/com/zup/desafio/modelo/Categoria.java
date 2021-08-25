package com.zup.desafio.modelo;

import com.zup.desafio.web.CategoriaRequest;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    public Categoria(CategoriaRequest request) {
        this.nome = request.getNome();
    }

    @Deprecated
    public Categoria() {
    }
}
