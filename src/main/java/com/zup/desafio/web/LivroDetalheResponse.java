package com.zup.desafio.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.desafio.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    private String nomeAutor;
    private String descricaoAutor;

    public LivroDetalheResponse(Livro livro) {
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numeroDePaginas = livro.getNumeroDePaginas();
        isbn = livro.getIsbn();
        dataPublicacao = livro.getDataPublicacao();
        nomeAutor = livro.getAutor().getNome();
        descricaoAutor = livro.getAutor().getDescricao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
