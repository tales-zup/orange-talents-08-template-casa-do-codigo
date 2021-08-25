package com.zup.desafio.web;


import com.zup.desafio.modelo.Livro;

public class LivroListagemResponse {

    private Long id;
    private String titulo;

    public LivroListagemResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
