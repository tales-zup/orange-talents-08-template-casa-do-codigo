package com.zup.desafio.modelo;

import com.zup.desafio.web.LivroRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(LivroRequest request) {
        this.titulo = request.getTitulo();
        this.resumo = request.getResumo();
        this.sumario = request.getSumario();
        this.preco = request.getPreco();
        this.numeroDePaginas = request.getNumeroDePaginas();
        this.isbn = request.getIsbn();
        this.dataPublicacao = request.getDataPublicacao();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
