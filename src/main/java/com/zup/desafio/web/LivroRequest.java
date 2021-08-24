package com.zup.desafio.web;


import com.zup.desafio.validation.UniqueValue;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotEmpty
    @UniqueValue(domainClass = LivroRequest.class, fieldName = "titulo", message = "Já existe um Livro com esse titulo.")
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
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long idAutor;

    @NotNull
    private Long idCategoria;

}
