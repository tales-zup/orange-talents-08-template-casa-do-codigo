package com.zup.desafio.web;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.desafio.modelo.Autor;
import com.zup.desafio.modelo.Categoria;
import com.zup.desafio.modelo.Livro;
import com.zup.desafio.validation.ExistsId;
import com.zup.desafio.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotEmpty
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Já existe um Livro com esse titulo.")
    private String titulo;

    @NotEmpty
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroDePaginas;

    @NotEmpty
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Já existe um Livro com esse isbn.")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id", message = "Esse autor não existe.")
    private Long idAutor;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Essa categoria não existe.")
    private Long idCategoria;

    public Livro converter(EntityManager em) {
        Categoria categoria = em.find(Categoria.class, this.idCategoria);
        Autor autor = em.find(Autor.class, this.idAutor);
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas,
                isbn, dataPublicacao, categoria, autor);
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

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
}
