package com.zup.desafio.modelo;

import com.zup.desafio.web.AutorRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Length(max = 400)
    private String descricao;

    @NotNull
    private LocalDate dataCadastro;

    public Autor(AutorRequest request) {
        nome = request.getNome();
        email = request.getEmail();
        descricao = request.getDescricao();
        dataCadastro = LocalDate.now();
    }

    @Deprecated
    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
