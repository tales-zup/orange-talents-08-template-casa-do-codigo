package com.zup.desafio.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroDePaginas;
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

}
